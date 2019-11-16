package com.tuoren.http;

import com.tuoren.http.request.IRequest;

import java.util.Map;

/**
 * Create by JDT on 2019/11/15.
 */
public class LfHttpServer {
    protected Object execute(IRequest request, Map<String, Object> params) {
        return HttpHelper.execute(request, params);
    }
}
