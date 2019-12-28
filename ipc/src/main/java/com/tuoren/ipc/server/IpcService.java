package com.tuoren.ipc.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.tuoren.ipc.IClientInterface;
import com.tuoren.ipc.IServerInterface;

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
                switch (requestKey) {
                    case shanghai_detail:

                }

            }

            @Override
            public String executeSync(String requestKey, String requestParams) throws RemoteException {
                return null;
            }

            @Override
            public void registeCallBack(IClientInterface iClientInterface) throws RemoteException {
                this.mClientInterface = iClientInterface;
            }
        };
    }
}
