package com.tuoren.http;

import com.tuoren.http.request.IRequest;
import com.tuoren.http.request.call.ICall;

/**
 * Create by JDT on 2019/11/16.
 */
public abstract class HttpScheduler {

    public abstract ICall newCall(IRequest request);

    public Object execute(ICall call) {
        return  call.execute();
    }
}
