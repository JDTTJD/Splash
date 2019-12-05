package com.tuoren.splash.splash;

import com.tuoren.annotation.MvpEmptyViewFactory;
import com.tuoren.mvp.mvp.ILifeCircle;
import com.tuoren.mvp.mvp.IMvpView;
import com.tuoren.mvp.mvp.MvpController;

/**
 * Create by JDT on 2019/11/7.
 */
public interface ISpalshActivityContract {

    @MvpEmptyViewFactory
    interface Iview extends IMvpView {
        void setTvTimer(String timer);
    }

    interface IPresenter extends ILifeCircle {
        void initTimer();
    }

    Iview emptyView = new Iview() {
        @Override
        public void setTvTimer(String timer) {
            setTvTimer(timer);
            emptyView.setTvTimer(timer);

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
