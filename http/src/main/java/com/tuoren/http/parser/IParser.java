package com.tuoren.http.parser;

import com.tuoren.http.request.IRequest;
import com.tuoren.http.response.IResponse;
import com.tuoren.http.result.IResult;

/**
 * Create by JDT on 2019/11/21.
 */
public interface IParser {
    IResult parseResponse(IRequest request, IResponse iResponse);
}
