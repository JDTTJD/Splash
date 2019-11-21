package com.tuoren.http.okhttp;

import com.tuoren.http.response.IResponse;

import java.io.IOException;

import okhttp3.Response;

/**
 * Create by JDT on 2019/11/21.
 */
public class OkHttpResponse implements IResponse {

    private final Response response;

    public OkHttpResponse(Response response) {
        this.response = response;
    }

    @Override
    public String getBodyStr() {
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
