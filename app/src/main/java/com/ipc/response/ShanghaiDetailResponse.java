package com.ipc.response;

import android.os.RemoteException;

import com.tuoren.ipc.IClientInterface;
import com.tuoren.ipc.response.BaseResponse;

/**
 * Create by JDT on 2020-01-02.
 */
public class ShanghaiDetailResponse extends BaseResponse {

    public ShanghaiDetailResponse(String resquestKey, String params, IClientInterface mClientInterface) {
        super(resquestKey, params, mClientInterface);
    }

    public void shanghaiDetail() {
        try {
            mClientInterface.callBack(mRequestKey, "来自远方的祝福");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
