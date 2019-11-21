package com.tuoren.http.request.call;

import com.tuoren.http.request.IRequest;
import com.tuoren.http.response.IResponse;

/**
 * Create by JDT on 2019/11/16.
 */
public interface ICall {
    IResponse execute();

    IRequest getRequest();

}
