package com.wudashan.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象任务，封装公共处理逻辑
 */
public abstract class BaseTask<T> implements Task {

    // 日志工具
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 任务相关参数
    protected final T t;

    public BaseTask(T t) {
        this.t = t;
    }

    @Override
    public void execute() {

        logger.info("enter execute method...");

        try {
            // 在执行任务前做一些准备操作
            preExecute(t);
        } catch (Exception e) {
            // 准备失败，没有执行任务的条件，任务不执行
            logger.error("preExecute method occur exception, task will not execute, exception:{}", e);
            return;
        }

        try {
            // 执行真正的任务
            doExecute(t);
        } catch (Exception e) {
            // 执行失败，记录错误日志
            logger.error("doExecute method occur exception, exception:{}", e);
        } finally {
            try {
                // 无论执行任务是否成功，都调用执行后方法，确保任务完全结束
                postExecute(t);
            } catch (Exception e) {
                logger.error("postExecute method occur exception, exception:{}", e);
            }
        }

        logger.info("exit execute method...");

    }

    /**
     * 执行任务前方法
     * 通常执行一个任务前需要先做一些准备，如加载资源，获取锁等等操作。
     */
    protected void preExecute(T t) {}

    /**
     * 执行任务方法，由子类实现具体的业务
     */
    protected abstract void doExecute(T t);

    /**
     * 执行任务后方法
     * 通常执行完一个任务后需要做一些善后工作，如释放资源，释放锁等等操作。
     *
     */
    protected void postExecute(T t) {}

}
