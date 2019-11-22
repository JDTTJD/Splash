package com.tuoren.http.result;

/**
 * Create by JDT on 2019/11/22.
 */
public interface IResultCallBack<T> {
    void onSuccess(IResult<T> t);
    void onFailed(IResult t);
}
