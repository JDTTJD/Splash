package com.tuoren.http.parser;

import com.google.gson.Gson;
import com.tuoren.http.request.IRequest;
import com.tuoren.http.response.IResponse;
import com.tuoren.http.result.IResult;
import com.tuoren.http.result.Result;

import java.lang.reflect.Type;

/**
 * Create by JDT on 2019/11/21.
 */
public class DefaultResultParse implements IParser {

    private static DefaultResultParse instance;
    private final Gson mGson;

    private DefaultResultParse() {
        mGson = new Gson();
    }

    public static IParser getInstance() {
        if (instance == null) {
            instance = new DefaultResultParse();
        }
        return instance;
    }

    @Override
    public IResult parseResponse(IRequest request, IResponse iResponse) {
        Type type = request.getType();
        String bodyStr = iResponse.getBodyStr();
        Object object = mGson.fromJson(bodyStr, type);
        return Result.success(object);
    }
}
