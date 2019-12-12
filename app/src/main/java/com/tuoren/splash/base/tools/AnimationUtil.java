package com.tuoren.splash.base.tools;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Create by JDT on 2019/12/12.
 */
public class AnimationUtil {

    /**
     * X轴方向的属性动画
     * @param target
     * @param positionStart
     * @param positionEnd
     * @param listener
     */
    public static void startTranslationXAnim(View target, float positionStart, float positionEnd, Animator.AnimatorListener listener) {
        ObjectAnimator welcomeAnim = ObjectAnimator.ofFloat(target, "translationX",
                positionStart, positionEnd);
        welcomeAnim.setDuration(1000);
        welcomeAnim.start();
        if (listener != null) {
            welcomeAnim.addListener(listener);
        }
    }
}
