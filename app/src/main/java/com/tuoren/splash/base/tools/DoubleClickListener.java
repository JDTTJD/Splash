package com.tuoren.splash.base.tools;

import android.view.View;

/**
 * Create by JDT on 2019/12/12.
 */
public class DoubleClickListener implements View.OnClickListener {

    private final View.OnClickListener mOnClickListener;
    private long old;

    public DoubleClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override

    public void onClick(View v) {
        long now = System.currentTimeMillis();
        if (now - old > 1000) {
            if (mOnClickListener != null) {
                mOnClickListener.onClick(v);
            }
        }
        old = now;
    }

}
