package com.tuoren.splash.base;

import android.app.Application;

import com.tuoren.splash.base.crash.CrashProtectManager;

/**
 * Create by JDT on 2019/12/7.
 */
public class SplashApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashProtectManager.getInstance(this).init();
    }
}
