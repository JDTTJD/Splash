package com.tuoren.splash.base;

import com.tuoren.http.result.IResult;
import com.tuoren.task.LfTask;

/**
 * Create by JDT on 2019/11/21.
 */
public class JHTask<T> extends LfTask<IResult<T>> {

    @Override
    public IResult<T> onBackground() {
        return null;
    }

    @Override
    public void onSuccess(IResult<T> o) {

    }

    @Override
    public void onException(Throwable throwable) {

    }
}
