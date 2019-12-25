package com.tuoren.ipc.result;

/**
 * Create by JDT on 2019-12-25.
 */
public interface IResult {

    boolean isSuccess();

    int getCode();

    String data();
}
