package com.tuoren.splash.main.shanghai.If;

import android.content.Context;

import com.tuoren.annotation.MvpEmptyViewFactory;
import com.tuoren.mvp.mvp.ILifeCircle;
import com.tuoren.mvp.mvp.IMvpView;

/**
 * Create by JDT on 2019/11/16.
 */
public interface IPlayerServiceContract {
    @MvpEmptyViewFactory
    interface Iview extends IMvpView {


    }

    interface IPresenter extends ILifeCircle {
        void bindService(Context context);

        void playOrPaused();
    }

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