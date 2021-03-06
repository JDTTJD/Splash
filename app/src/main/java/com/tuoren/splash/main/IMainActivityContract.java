package com.tuoren.splash.main;

import com.tuoren.annotation.MvpEmptyViewFactory;
import com.tuoren.mvp.mvp.ILifeCircle;
import com.tuoren.mvp.mvp.IMvpView;
import com.tuoren.mvp.mvp.MvpController;

import androidx.fragment.app.Fragment;

/**
 * Create by JDT on 2019/11/7.
 */
public interface IMainActivityContract {

    @MvpEmptyViewFactory
    interface Iview extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment fragment);
    }

    interface IPresenter extends ILifeCircle {

        int getTopPosition();

        int getBottomPosition();

        void initHomeFragment();

        int getCurrentCheckedIndex();

        int getCurrentCheckedId();

        void replaceFragment(int mCurrentFragmentIndex);
    }

    Iview emptyView = new Iview() {

        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public void addFragment(Fragment mFragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
