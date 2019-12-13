package com.tuoren.splash.base.helper;

import android.app.Application;
import android.content.Context;

/**
 * Create by JDT on 2019/12/13.
 */
public class ContextHelper {

    private static ContextHelper mInstance;

    private Application mApplication;

    public static ContextHelper getInstance() {
        if (mInstance == null) {
            mInstance = new ContextHelper();
        }
        return mInstance;
    }

    public void init(Application application) {
        this.mApplication = application;
    }

    public Context getApplicationContext() {
        return mApplication.getApplicationContext();
    }

}
