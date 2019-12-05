package com.tuoren.splash.splash;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.tuoren.mvp.mvp.base.BaseMvpPresenter;

/**
 * Create by JDT on 2019/11/7.
 */
public class SplashTimerPresent extends BaseMvpPresenter<ISpalshActivityContract.Iview> implements ISpalshActivityContract.IPresenter {

    private CustomCountDownTimer timer;

    public SplashTimerPresent(ISpalshActivityContract.Iview view) {
        super(view);
    }


    public void initTimer() {
        timer = new CustomCountDownTimer(3, new CustomCountDownTimer.ICountDownHandle() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }


    @Override
    public void destroyView() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        Log.e("SplashTimerPresent", "onDestroy");
    }

    @Override
    protected ISpalshActivityContract.Iview getEmptyView() {
        return ISpalshActivityContract.emptyView;
        //return MvpEmptyViewFactory.create();
    }
}
