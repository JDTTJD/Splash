package com.tuoren.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.tuoren.task.tools.ThreadUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;


/**
 * Create by JDT on 2019/11/19.
 */
public class TaskScheduler {

    private final PriorityThreadPoolExecutor executor;

    interface ITaskScheduleType {
        int SUBMIT_TASK = 0;
    }
    private static TaskScheduler instance;
    private final Handler handler;
    private int COREPOOLSIZE = ThreadUtil.CPU_NUM + 1;
    private int MAXIMUMPOOLSIZE = COREPOOLSIZE * 3;
    private int KEEPALIVETIME = 1;

    private TaskScheduler() {
        //用于消息调度的线程
        HandlerThread handlerThread = new HandlerThread("task-thread");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() {
            //handlerThread handlerMessage运行在子线程
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case ITaskScheduleType.SUBMIT_TASK:
                        doSubmitTask((AsyncTaskInstance) msg.obj);
                        break;
                }
                return false;
            }
        });
        //创建一个线程池
        BlockingQueue<Runnable> poolQueue = new LinkedBlockingDeque<>();//无大小限制的队列
        this.executor = new PriorityThreadPoolExecutor(COREPOOLSIZE, MAXIMUMPOOLSIZE,KEEPALIVETIME,
                TimeUnit.MINUTES, poolQueue, new TaskThreadFactory());
    }

    private void doSubmitTask(AsyncTaskInstance taskInstance) {
        executor.submit(taskInstance);
    }

    public static TaskScheduler getInstance() {
        if (instance == null) {
            instance = new TaskScheduler();
        }
        return instance;
    }

    public void submit(AsyncTaskInstance instance) {
        handler.sendMessage(handler.obtainMessage(ITaskScheduleType.SUBMIT_TASK, instance));
    }
}
