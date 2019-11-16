package com.tuoren.task;

/**
 * Create by JDT on 2019/11/16.
 */
public interface ITaskCallback {
    void onSuccess(Object o);
    void onException(Throwable throwable);
}
