package com.tuoren.splash.splash;

import com.tuoren.splash.mvp.ILifeCircle;
import com.tuoren.splash.mvp.IMvpView;
import com.tuoren.splash.mvp.MvpController;

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

    Iview emptyView = new Iview() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
