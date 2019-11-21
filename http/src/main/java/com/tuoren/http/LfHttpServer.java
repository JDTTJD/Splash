package com.tuoren.http;

import com.tuoren.http.request.IRequest;
import com.tuoren.http.result.IResult;

import java.util.Map;

/**
 * Create by JDT on 2019/11/15.
 */
public class LfHttpServer {
    protected <T> IResult<T> execute(IRequest request, Map<String, Object> params) {
        return HttpHelper.execute(request, params);
    }
}
