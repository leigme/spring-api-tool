package me.leig.server.spring.api.tool.service;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @Author leig
 * @Date 2021/4/5
 **/
public interface ThreadPoolFactory {

    ExecutorService newSingleThreadExecutor();

    ThreadPoolExecutor newThreadPoolExecutor(// 核心线程池大小
                                             int corePoolSize,
                                             // 最大线程池大小
                                             int maximumPoolSize,
                                             // 线程最大空闲时间
                                             int keepAliveTime,
                                             // 时间单位
                                             TimeUnit unit,
                                             // 线程等待队列
                                             BlockingQueue<Runnable> workQueue,
                                             // 线程创建工厂
                                             ThreadFactory threadFactory,
                                             // 拒绝策略
                                             RejectedExecutionHandler handler);

}
