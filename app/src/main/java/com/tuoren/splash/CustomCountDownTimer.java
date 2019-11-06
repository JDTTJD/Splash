package com.tuoren.splash;


import android.os.Handler;

/**
 * Create by JDT on 2019/11/5.
 */
public class CustomCountDownTimer implements Runnable{

    private int time;
    private int countDowntime;
    private final ICountDownHandle countDownHandle;
    private final Handler handler;
    private boolean isRun;


    //1、时时去回调 这个时候是什么时间 倒计时到几秒
    //2、支持动态传入总时间
    //3、每过一秒 减一
    //4、总时间倒计时为时，要回调完成的状态

    public CustomCountDownTimer(int time, ICountDownHandle countDownHandle){

        handler = new Handler();
        this.time = time;
        this.countDowntime = time;
        this.countDownHandle = countDownHandle;

    }

    //实现具体逻辑
    @Override
    public void run() {
        if (isRun) {
            if (countDownHandle != null) {
                countDownHandle.onTicker(countDowntime);
            }
            if (countDowntime == 0) {
                cancel();
                if (countDownHandle != null) {
                    countDownHandle.onFinish();
                }
            } else {
                countDowntime = time--;
                handler.postDelayed(this,1000);
            }
        }
    }

    //run的开关
    public void start() {
        isRun = true;

        handler.post(this);
    }

    //跳出循环 终止
    public void cancel() {
        isRun = false;
        handler.removeCallbacks(this);
    }

    //观察者回调接口 (ICO 数据回调)
    public interface ICountDownHandle {
        //倒计时回调
        void onTicker(int time);
        //完成时回调
        void onFinish();
    }
}
