package com.tuoren.splash.base;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.tuoren.splash.splash.SplashActivity;

/**
 * Create by JDT on 2019/12/5.
 */
public class Test extends Application {

    private static SplashActivity haha;

    public static void save(SplashActivity splashActivity) {
        haha = splashActivity;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //LeakCanary的初始化
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
