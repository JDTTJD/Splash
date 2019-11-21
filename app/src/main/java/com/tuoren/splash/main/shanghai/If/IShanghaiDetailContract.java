package com.tuoren.splash.main.shanghai.If;

import com.tuoren.mvp.mvp.ILifeCircle;
import com.tuoren.mvp.mvp.IMvpView;
import com.tuoren.mvp.mvp.MvpController;

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
// ason的
//public interface IShanghaiDetailContract {
//    @MvpEmptyViewFactory
//    interface Iview extends IMvpView {
//
//
//        void showData(ShangHaiDetailBean data);
//    }
//
//    interface IPresenter extends ILifeCircle {
//
//        void getNetData(int pagesize);
//    }

//    IShanghaiDetailContract.Iview emptyView = new IShanghaiDetailContract.Iview() {
//
//        @Override
//        public void showData(ShangHaiDetailBean data) {
//
//        }
//
//        @Override
//        public MvpControler getMvpControler() {
//            return null;
//        }
//    };
//}