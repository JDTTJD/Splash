package com.tuoren.splash.splash;

import android.content.Context;

/**
 * Create by JDT on 2019/12/5.
 */
public class MemoryTest {
    private static MemoryTest mContext;
    private final Context context;

    public MemoryTest(Context context) {
        this.context = context.getApplicationContext();
    }

    public static MemoryTest getInstance(Context context) {
        if (mContext == null) {
            mContext = new MemoryTest(context);
        }
        return mContext;
    }
}
