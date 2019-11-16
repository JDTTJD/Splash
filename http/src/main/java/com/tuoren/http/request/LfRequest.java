package com.tuoren.http.request;

import com.tuoren.http.annotation.RequestMethod;
import com.tuoren.http.request.host.IHost;

import java.util.Map;

/**
 * Create by JDT on 2019/11/15.
 */
public class LfRequest implements IRequest {

    protected String path;

    protected IHost host;

    protected Map<String, Object> params;
    @RequestMethod
    protected int requestMethod;

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public int getRequestMerhod() {
        return requestMethod;
    }

    @Override
    public IHost getHost() {
        return host;
    }

    @Override
    public String getPath() {
        return path;
    }

}
