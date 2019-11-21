package com.tuoren.http;

import com.tuoren.http.parser.IParser;
import com.tuoren.http.request.IRequest;
import com.tuoren.http.request.call.ICall;
import com.tuoren.http.response.IResponse;
import com.tuoren.http.result.IResult;

/**
 * Create by JDT on 2019/11/16.
 */
public abstract class HttpScheduler {

    public abstract ICall newCall(IRequest request);

    public IResult execute(ICall call) {
        //IResponse和IResult进行一个转换
        IResponse iResponse = call.execute();
        IRequest request = call.getRequest();
        IParser parser = request.getParser();
        return  parser.parseResponse(request,iResponse);
    }
}
