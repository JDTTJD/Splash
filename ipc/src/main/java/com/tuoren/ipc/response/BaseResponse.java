package com.tuoren.ipc.response;

import com.tuoren.ipc.IClientInterface;

/**
 * Create by JDT on 2020-01-02.
 */
public class BaseResponse {

    public final String mRequestKey;
    public final String mParams;
    public final IClientInterface mClientInterface;

    public BaseResponse(String resquestKey, String params, IClientInterface mClientInterface) {
        this.mRequestKey = resquestKey;
        this.mParams = params;
        this.mClientInterface = mClientInterface;
    }
}
