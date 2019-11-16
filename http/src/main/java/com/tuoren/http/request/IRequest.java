package com.tuoren.http.request;

import com.tuoren.http.request.host.IHost;

import java.util.Map;

/**
 * Create by JDT on 2019/11/15.
 */
public interface IRequest {

    void setParams(Map<String, Object> params);
    Map<String, Object> getParams();
    int getRequestMerhod();
    IHost getHost();
    String getPath();
}
