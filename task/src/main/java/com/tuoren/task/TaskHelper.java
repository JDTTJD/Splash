package com.tuoren.task;

/**
 * Create by JDT on 2019/11/16.
 */
public class TaskHelper {
    public static void submitTask(ITaskBackground iTaskBackground,ITaskCallback iTaskCallback) {
        AsyncTaskInstance instance = AsyncTaskInstance.getInstance(iTaskBackground, iTaskCallback);
        //构建线程池管理器
        TaskSchedule.getInstance().submit(instance);
    }
}
