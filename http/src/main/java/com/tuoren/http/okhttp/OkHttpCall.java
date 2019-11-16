package com.tuoren.http.okhttp;

import com.tuoren.http.request.IRequest;
import com.tuoren.http.request.call.ICall;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Create by JDT on 2019/11/16.
 */
public class OkHttpCall implements ICall {

    private Call call;

    public OkHttpCall(IRequest request, Call call) {
        this.call = call;
    }

    @Override
    public Object execute() {
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
