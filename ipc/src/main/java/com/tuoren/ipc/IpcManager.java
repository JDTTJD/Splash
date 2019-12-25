package com.tuoren.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;

import com.tuoren.ipc.request.IRequest;
import com.tuoren.ipc.result.IResult;
import com.tuoren.ipc.result.IpcResult;
import com.tuoren.ipc.server.IpcService;

import java.util.Set;
import java.util.TreeSet;


/**
 * Create by JDT on 2019-12-25.
 */
public class IpcManager {

    private static IpcManager mInstance;
    private final Context mContext;
    private Set<IRequest> mRequests = new TreeSet<IRequest>();
    private int mConnectStatus = IConnectStatus.STATUS_UNBIND;
    private ServiceConnection mConnection;
    private IServerInterface mServer;

    interface IConnectStatus {
        int STATUS_UNBIND = 0;
        int STATUS_BINDING = 1;
        int STATUS_BIND = 2;
    }

    private IpcManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public synchronized static IpcManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new IpcManager(context);
        }
        return mInstance;
    }

    //同步请求
    public IResult executeSync(IRequest request) {
        if (TextUtils.isEmpty(request.getRequestKey()) || mRequests.contains(request)) {
            return IpcResult.getErrorResult();
        }
        mRequests.add(request);
        //判断服务是否已经连接成功
        if (mConnectStatus == IConnectStatus.STATUS_UNBIND) {
            connectService();
            return IpcResult.getErrorResult();
        }
        return execute(request);
    }

    //异步跨进程通信
    public void executeAsync(IRequest request, CallBack callBack) {
        if (TextUtils.isEmpty(request.getRequestKey()) || mRequests.contains(request)) {
            callBack.callBack(IpcResult.getErrorResult());
            return;
        }
        //保存这个request
        request.addCallBack(callBack);
        mRequests.add(request);
        //判断服务是否已经连接成功
        if (mConnectStatus == IConnectStatus.STATUS_UNBIND) {
            connectService();
            return;
        }
        execute(request);

    }

    //建立 IPC通讯连接
    private void connectService() {
        if (mConnection == null) {
            mConnection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    mServer = IServerInterface.Stub.asInterface(service);
                    //Binder 通信的死亡通知 有重启逻辑
//                    service.linkToDeath();
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            };
        }

        Intent intent = new Intent(mContext, IpcService.class);
        mContext.bindService(intent, mConnection, Service.BIND_AUTO_CREATE);
    }

    //实际  跨进程通讯的方法
    private IResult execute(IRequest request) {
        if (request.getCallBack() != null) {
            try {
                // CODEREVIEW: 代码审核: 这里面待解决 AIDL的回调问题
                mServer.executeAsync(request.getRequestKey(), request.getParams());
            } catch (RemoteException e) {
                request.getCallBack().callBack(IpcResult.getErrorResult());
            }
        } else {
            try {
                String result = mServer.executeSync(request.getRequestKey(), request.getParams());
                return IpcResult.getSuccessResult(result);
            } catch (RemoteException e) {
                return IpcResult.getErrorResult();
            }
        }
        return IpcResult.getErrorResult();
    }

}
