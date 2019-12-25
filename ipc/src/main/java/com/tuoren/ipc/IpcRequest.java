package com.tuoren.ipc;

import com.tuoren.ipc.request.IRequest;

import androidx.annotation.NonNull;

/**
 * Create by JDT on 2019-12-25.
 */
public class IpcRequest implements IRequest {

    private final String mRequestKey;
    private String mParams;
    private CallBack mCallBack;

    public IpcRequest(@NonNull String requestKey) {
        this.mRequestKey = requestKey;
    }

    @Override
    public void setParams(@NonNull String params) {
        this.mParams = params;
    }

    @Override
    public String getParams() {
        return mParams;
    }

    @Override
    public String getRequestKey() {
        return mRequestKey;
    }

    @Override
    public void addCallBack(CallBack callBack) {
        this.mCallBack = callBack;
    }

    @Override
    public CallBack getCallBack() {
        return mCallBack;
    }
}
