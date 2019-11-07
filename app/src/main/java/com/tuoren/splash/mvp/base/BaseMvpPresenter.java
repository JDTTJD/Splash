package com.tuoren.splash.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import com.tuoren.splash.mvp.IMvpView;
import com.tuoren.splash.mvp.presenter.LifeCircleMvpPresenter;

/**
 * Create by JDT on 2019/11/7. P层的中间类
 */
public abstract class BaseMvpPresenter<T extends IMvpView> extends LifeCircleMvpPresenter<T> {

    public BaseMvpPresenter(T view) {
        super(view);
    }


    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }


    @Override
    public void destroyView() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }

    @Override
    public void onDestroy() {

    }
}
