package com.tuoren.ipc.request;

import com.tuoren.ipc.CallBack;

/**
 * Create by JDT on 2019-12-25.
 */
public interface IRequest extends Comparable<IRequest>{

    void setParams(String params);

    String getParams();

    String getRequestKey();

    void addCallBack(CallBack callBack);

    CallBack getCallBack();

    long getAddTime();
}
