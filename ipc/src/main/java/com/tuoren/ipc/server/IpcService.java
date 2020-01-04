package com.tuoren.ipc.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.tuoren.ipc.IClientInterface;
import com.tuoren.ipc.IServerInterface;
import com.tuoren.ipc.response.ResponseUtil;

import androidx.annotation.Nullable;

/**
 * Create by JDT on 2019-12-25.
 */
public class IpcService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new IServerInterface.Stub() {
            private IClientInterface mClientInterface;

            @Override
            public void executeAsync(String requestKey, String requestParams) throws RemoteException {

                ResponseUtil.getAsyncResponse(requestKey, requestParams, mClientInterface);
            }

            @Override
            public String executeSync(String requestKey, String requestParams) throws RemoteException {
                String result = "";
                switch (requestKey) {
                    case "shanghaiDetail":
                        result = "来自远方的祝福";
                        break;
                    default:
                        break;
                }
                return result;
            }

            @Override
            public void registeCallBack(IClientInterface iClientInterface) throws RemoteException {
                this.mClientInterface = iClientInterface;
            }
        };
    }
}
