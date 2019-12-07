package com.tuoren.splash.base.crash;

import android.content.Context;

/**
 * Create by JDT on 2019/12/7.
 */
public class CrashProtectManager {

    private static CrashProtectManager mInstance;
    private static Context mContext;

    private CrashProtectManager() {

    }

    public static CrashProtectManager getInstance(Context context) {
        if (mInstance == null) {
            mContext = context.getApplicationContext();
            mInstance = new CrashProtectManager();
        }
        return mInstance;
    }

    public void init() {
        // crash 防护
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //退出操作
                
            }
        });
    }

}
