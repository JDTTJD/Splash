package com.tuoren.splash.main.shanghai.If;

import com.tuoren.splash.mvp.ILifeCircle;
import com.tuoren.splash.mvp.IMvpView;
import com.tuoren.splash.mvp.MvpController;

/**
 * Create by JDT on 2019/11/16.
 */
public interface IShanghaiDetailContract {
    interface Iview extends IMvpView {

    }

    interface IPresenter extends ILifeCircle {
        void getNetData();
    }

    IShanghaiDetailContract.Iview emptyView = new IShanghaiDetailContract.Iview() {

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
