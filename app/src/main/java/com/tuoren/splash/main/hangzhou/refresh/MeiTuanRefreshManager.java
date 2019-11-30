package com.tuoren.splash.main.hangzhou.refresh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.tuoren.refresh.BaseRefreshManager;
import com.tuoren.splash.R;

/**
 * Create by JDT on 2019/11/30.
 */
public class MeiTuanRefreshManager extends BaseRefreshManager {

    private ImageView mImageView;

    public MeiTuanRefreshManager(Context context) {
        super(context);
    }

    @Override
    public View getHeadView() {
        View inflate = mLayoutInflater.inflate(R.layout.meituan_header_refresh_layout, null, false);
        mImageView = inflate.findViewById(R.id.loading);
        return inflate;
    }

    //这个回调 只会触发一次
    @Override
    public void downRefresh() {

    }

    //释放刷新的时候变成美团吉祥物图片
    @Override
    public void releaseRefresh() {
        mImageView.setImageResource(R.drawable.mei_tuan_loading_pre);
        AnimationDrawable mAnimationDrawable = (AnimationDrawable) mImageView.getDrawable();
        mAnimationDrawable.start();
    }

    @Override
    public void iddleRefresh() {
        mImageView.clearAnimation();
        mImageView.setImageResource(R.mipmap.pull_image);
        mImageView.setScaleX(0);
        mImageView.setScaleY(0);
    }

    //正在刷新的状态也是一个帧动画
    @Override
    public void refreshing() {
        mImageView.setImageResource(R.drawable.mei_tuan_loading);
        AnimationDrawable mAnimationDrawable = (AnimationDrawable) mImageView.getDrawable();
        mAnimationDrawable.start();
    }

    @Override
    public void downRefreshPercent(float percent) {
        Log.e("downRefreshPercent", "percent: " + percent );
        mImageView.setScaleX(percent);
        mImageView.setScaleY(percent);
    }
}
