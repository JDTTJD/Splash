package com.tuoren.splash.base;

import com.tuoren.splash.mvp.IMvpView;
import com.tuoren.splash.mvp.base.BaseMvpPresenter;
import com.tuoren.task.LfTask;
import com.tuoren.task.TaskHelper;

/**
 * Create by JDT on 2019/11/16.集成mvp 及网络请求快捷方式
 */
public abstract class BasePresenter<T extends IMvpView> extends BaseMvpPresenter<T> {

    public BasePresenter(T view) {
        super(view);
    }

    public void submitTask(LfTask task) {
        TaskHelper.submitTask(task,task);
    }
}
