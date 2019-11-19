package com.tuoren.task.tools;


import android.os.Handler;
import android.os.Looper;

/**
 * Create by JDT on 2019/11/18.
 */
public class ThreadUtil {

    //主线程的 Handler
    private final static Handler MAIN = new Handler(Looper.getMainLooper());
    //当前设备的CPU数量
    public static int CPU_NUM = Runtime.getRuntime().availableProcessors();

    public static void postMainThread(final Runnable runnable) {
        MAIN.post(new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
