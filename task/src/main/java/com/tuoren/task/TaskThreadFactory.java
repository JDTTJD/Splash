package com.tuoren.task;

import java.util.concurrent.ThreadFactory;

/**
 * Create by JDT on 2019/11/20.
 */
public class TaskThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "task_thread_pool");
    }
}
