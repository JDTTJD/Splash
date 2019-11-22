package com.tuoren.splash.base;

import com.tuoren.http.result.IResult;
import com.tuoren.http.result.IResultCallBack;
import com.tuoren.http.result.Result;
import com.tuoren.task.LfTask;

/**
 * Create by JDT on 2019/11/21.
 */
public abstract class JHTask<T> extends LfTask<IResult<T>> implements IResultCallBack<T> {


    @Override
    public void onComplete(IResult<T> iResult) {
        if (iResult != null) {
            if (iResult.isSuccess()) {
                onSuccess(iResult);
            } else {
                onFailed(Result.failed(Result.CODE_505)); //1次失败
            }
        } else {
            onFailed(Result.failed(Result.CODE_404)); //2次失败
        }
    }

    @Override
    public void onFailed(IResult t) {
        //可以做成统一错误码的处理
        switch (t.getCode()) {
            case Result.CODE_404:

                break;
            case Result.CODE_504:

                break;
        }
    }

    @Override
    public void onException(Throwable throwable) {
        onFailed(Result.failed(Result.CODE_504)); //3次失败
    }
}
