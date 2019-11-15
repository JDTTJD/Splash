package com.tuoren.splash.base;

import com.tuoren.http.IRequest;
import com.tuoren.http.annotation.RequestMethod;
import com.tuoren.http.request.LfRequest;

/**
 * Create by JDT on 2019/11/15.
 */
public class JHRequest extends LfRequest{
    public static IRequest sendHttp(String path, @RequestMethod int requestMethod) {
        JHRequest request = new JHRequest();
        request.host = HostManager.jhHost;
        request.requestMethod = requestMethod;
        return request;
    }
}
