package me.leig.server.spring.api.tool.service.impl;

import me.leig.server.spring.api.tool.service.ThreadPoolFactory;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/5
 **/
public enum ThreadPoolFactoryImpl implements ThreadPoolFactory {

    INSTANCE;

    @Override
    public ExecutorService newSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Override
    public ThreadPoolExecutor newThreadPoolExecutor(int corePoolSize, int maximumPoolSize, int keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        if (corePoolSize < 0 ||
                maximumPoolSize <= 0 ||
                maximumPoolSize < corePoolSize ||
                keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, unit.toNanos(keepAliveTime), unit, workQueue, threadFactory, handler);
    }
}
