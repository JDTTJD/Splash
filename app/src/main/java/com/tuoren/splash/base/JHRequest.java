package com.tuoren.splash.base;

import com.tuoren.http.annotation.RequestMethod;
import com.tuoren.http.parser.DefaultResultParse;
import com.tuoren.http.request.IRequest;
import com.tuoren.http.request.LfRequest;

import java.lang.reflect.Type;

/**
 * Create by JDT on 2019/11/15.
 */
public class JHRequest extends LfRequest{
    public static IRequest sendHttp(String path, @RequestMethod int requestMethod, Type type) {
        JHRequest request = new JHRequest();
        request.host = HostManager.jhHost;
        request.path = path;
        request.requestMethod = requestMethod;
        request.type = type;
        request.resultParser = DefaultResultParse.getInstance();
        return request;
    }
}
