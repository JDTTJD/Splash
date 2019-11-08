package com.tuoren.splash.main;

import com.tuoren.splash.R;
import com.tuoren.splash.main.shanghai.BeiJingFragment;
import com.tuoren.splash.main.shanghai.HangZhouFragment;
import com.tuoren.splash.main.shanghai.ShangHaiFragment;
import com.tuoren.splash.main.shanghai.ShenZhenFragment;
import com.tuoren.splash.mvp.base.BaseMvpPresenter;

import androidx.fragment.app.Fragment;

/**
 * Create by JDT on 2019/11/8.
 */
public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.Iview> implements IMainActivityContract.IPresenter {

    //当前Fragment脚标
    private int mCurrentFragmentIndex;

    private Fragment [] mFragments = new Fragment[4];
    private int mCurrentCheckedId;


    public MainActivityPresenter(IMainActivityContract.Iview view) {
        super(view);
    }

    @Override
    protected IMainActivityContract.Iview getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = 0;
        replaceFragment(mCurrentFragmentIndex);
    }

    //切换Fragment的方法
    private void replaceFragment(int mCurrentFragmentIndex) {
        for (int i = 0; i < mFragments.length; i++) {
            if (mCurrentFragmentIndex != i) {
                if (mFragments[i] != null) {
                    hideFragment(mFragments[i]);
                }
            }
        }

        Fragment mFragment = mFragments[mCurrentFragmentIndex];

        if (mFragment != null) {
            addAndShowFragment(mFragment);
            setCurChecked(mCurrentFragmentIndex);
        } else {
            newCurrentFragment(mCurrentFragmentIndex);
            setCurChecked(mCurrentFragmentIndex);
        }

    }

    //记录当前角标
    private void setCurChecked(int mCurrentFragmentIndex) {
        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch (mCurrentFragmentIndex) {
            case 0:
                mCurrentCheckedId = R.id.rb_main_shanghai;
                break;
            case 1:
                mCurrentCheckedId = R.id.rb_main_hangzhou;
                break;
            case 2:
                mCurrentCheckedId = R.id.rb_main_beijing;
                break;
            case 3:
                mCurrentCheckedId = R.id.rb_main_shenzhen;
                break;
        }

    }

    //创建当前Fragment
    private void newCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex) {
            case 0:
                fragment = new ShangHaiFragment();
                break;
            case 1:
                fragment = new HangZhouFragment();
                break;
            case 2:
                fragment = new BeiJingFragment();
                break;
            case 3:
                fragment = new ShenZhenFragment();
                break;
        }
        mFragments [mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    //显示Fragment
    private void addAndShowFragment(Fragment mFragment) {
        if (mFragment.isAdded()) {
            getView().showFragment(mFragment);
        } else {
            getView().addFragment(mFragment);
        }
    }

    //隐藏Fragment
    private void hideFragment(Fragment fragment) {
        if (fragment != null && fragment.isVisible()) {
            getView().hideFragment(fragment);
        }
    }
}
