package com.tuoren.task;

/**
 * Create by JDT on 2019/11/16.
 */
public interface ITaskCallback<Result> {
    void onComplete(Result o);
    void onException(Throwable throwable);
}
