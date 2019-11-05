package com.tuoren.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Create by JDT on 2019/11/4.
 */

public class FullScreenVideoView extends VideoView {
    //主要用于这个直接new出来的对象
    public FullScreenVideoView(Context context) {
        super(context);
    }
    //主要用于xml文件中
    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //宽
        int width = getDefaultSize(0, widthMeasureSpec);
        //高
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
