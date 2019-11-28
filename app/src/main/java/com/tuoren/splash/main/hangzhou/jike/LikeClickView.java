package com.tuoren.splash.main.hangzhou.jike;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.tuoren.splash.R;
import com.tuoren.splash.main.tools.SystemUtil;

import androidx.annotation.Nullable;

/**
 * Create by JDT on 2019/11/27.
 */
public class LikeClickView extends View {

    private boolean isLike;
    private Bitmap likeBitmap;
    private Bitmap unlikeBitmap;
    private Bitmap shiningBitmap;
    private Paint bitmapPaint;
    private int left;
    private int top;
    private float handScale = 1.0f;
    private int centerX;
    private int centerY;

    public LikeClickView(Context context) {
        this(context, null, 0);
        init();
    }

    public LikeClickView(Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
        init();
    }

    public LikeClickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取JikeLikeView
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.JikeLikeView);
        //得到其中isLike的布尔值
        isLike = typedArray.getBoolean(R.styleable.JikeLikeView_is_like, true);
        //记得recycle，内存友好的一种方式
        typedArray.recycle();
        init();
    }

    private void init() {
        Resources resources = getResources();
        likeBitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_message_like);
        unlikeBitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_message_unlike);
        shiningBitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_message_like_shining);
        bitmapPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureWidth = 0;
        int measureHeight = 0;
        int maxHeight = likeBitmap.getHeight() + SystemUtil.dp2px(getContext(), 20);
        int maxWidth = likeBitmap.getWidth() + SystemUtil.dp2px(getContext(), 30);
        //拿到当前控件的测量模式
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (mode != MeasureSpec.EXACTLY) {
            //未指定测量模式 如果有背景 背景有多大 这个控件就有多大
            int suggestedMinimumWidth = getSuggestedMinimumWidth();
            int suggestedMinimumHeight = getSuggestedMinimumHeight();
            if (suggestedMinimumWidth == 0) {
                measureWidth = maxWidth;
            } else {
                measureWidth = Math.min(suggestedMinimumWidth, maxWidth);
            }
            if (suggestedMinimumHeight == 0) {
                measureHeight = maxHeight;
            } else {
                measureHeight = Math.min(suggestedMinimumHeight, maxHeight);
            }
        } else {
            //测量模式制定 根据用户定义大小来判断
            measureWidth = Math.min(widthSize, maxWidth);
            measureHeight = Math.min(maxHeight, heightSize);
        }

        setMeasuredDimension(measureWidth, measureHeight);
        getPadding(measureWidth, measureHeight);
    }

    private void getPadding(int measureWidth, int measureHeight) {
        int bitmapWidth = likeBitmap.getWidth();
        int bitmapHeight = likeBitmap.getHeight();
        left = (measureWidth - bitmapWidth) / 2;
        top = (measureHeight - bitmapHeight) / 2;
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        centerX = width / 2;
        centerY = height / 2;
    }

    //当这个自定义View 从界面 脱离消失的时候
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        likeBitmap.recycle();
        unlikeBitmap.recycle();
        shiningBitmap.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap handBitmap = isLike ? likeBitmap : unlikeBitmap;
        //使用 canvan Scale及其他的效果方法时 必须先调用save 然后在调用restore（这两个方法成对出现）
        canvas.save();
        //与anson不同，他最后一个是centerX
        canvas.scale(handScale, handScale, centerX, centerY);
        canvas.drawBitmap(handBitmap, left, top, bitmapPaint);
        canvas.restore();
        if (isLike) {
            canvas.drawBitmap(shiningBitmap, left + 10, 0, bitmapPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                onClick();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    //待完善 动画的处理
    private void onClick() {
        isLike = !isLike;
//        ObjectAnimator handScale = ObjectAnimator.ofFloat(this, "handScale", 1.0f, 0.8f, 1.0f);
//        handScale.setDuration(250);
//        handScale.start();

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
        valueAnimator.setDuration(250);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                handScale = animatedValue;
                invalidate();
            }
        });
    }

    /**
     * 使用ObjectAnimator 系统会自动调用 该属性的set方法
     *
     * @param value
     */
    private void setHandScale(float value) {
        this.handScale = value;
        invalidate();
    }
}
