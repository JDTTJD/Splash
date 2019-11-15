package com.tuoren.http.request;

import com.tuoren.http.IRequest;
import com.tuoren.http.annotation.RequestMethod;
import com.tuoren.http.request.host.IHost;

/**
 * Create by JDT on 2019/11/15.
 */
public class LfRequest implements IRequest {

    protected IHost host;

    @RequestMethod
    protected int requestMethod;
}
