package com.tuoren.http.request;

import com.tuoren.http.parser.IParser;
import com.tuoren.http.annotation.RequestMethod;
import com.tuoren.http.request.host.IHost;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Create by JDT on 2019/11/15.
 */
public class LfRequest implements IRequest {

    protected String path;

    protected IHost host;

    protected Type type;

    protected IParser resultParser;

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

    @Override
    public IParser getParser() {
        return resultParser;
    }

    @Override
    public Type getType() {
        return type;
    }

}
