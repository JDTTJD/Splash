package com.tuoren.refresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Create by JDT on 2019/11/28.
 */
public abstract class BaseRefreshManager {

    public LayoutInflater mLayoutInflater;

    public BaseRefreshManager(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    public abstract View getHeadView();
}
