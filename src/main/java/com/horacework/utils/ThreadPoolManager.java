package com.horacework.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 大灯泡 on 2016/2/13.
 * 简单封装线程池
 */
public class ThreadPoolManager {
    private static ExecutorService threadPool = null;

    static {
        threadPool = Executors.newCachedThreadPool();
    }

    public static void execute(Runnable runnable){
        threadPool.execute(runnable);
    }

}
