package com.tuoren.splash.mvp;

/**
 * Create by JDT on 2019/11/7.
 */
public interface ISpalshActivityContract {

    interface Iview extends IMvpView {
        void setTvTimer(String timer);
    }

    interface IPresenter extends ILifeCircle {
        void initTimer();
    }

}
