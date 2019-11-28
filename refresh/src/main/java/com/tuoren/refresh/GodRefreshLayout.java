package com.tuoren.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * Create by JDT on 2019/11/28.
 */
public class GodRefreshLayout extends LinearLayout {

    private BaseRefreshManager mRefreshManager;

    public GodRefreshLayout(Context context) {
        super(context);
        initHeaderView();
    }

    public GodRefreshLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initHeaderView();
    }

    public GodRefreshLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initHeaderView();
    }
    /*
        开启下拉刷新 下拉刷新的效果 是默认的
     */
    public void setRefreshManager() {
        mRefreshManager = new DefaultRefreshManager();
    }

    /*
       开启下拉刷新 使用用户自定义的下拉刷新效果
     */
    public void setRefreshManager(BaseRefreshManager manager) {
        mRefreshManager = manager;
    }

    private void initHeaderView() {
        setOrientation(VERTICAL);
        addView(mRefreshManager.getHeadView());
    }
}
