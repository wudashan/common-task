package com.wudashan.task;

/**
 * 演示任务
 */
public class DemoTask extends BaseTask<String> {

    public DemoTask(String s) {
        super(s);
    }

    @Override
    protected void doExecute(String s) {
        logger.debug("doExecute, {}", s);
        //throw new RuntimeException();
    }

    @Override
    protected void preExecute(String s) {
        logger.debug("preExecute, {}", s);
        //throw new RuntimeException();
    }

    @Override
    protected void postExecute(String s) {
        logger.debug("postExecute, {}", s);
        //throw new RuntimeException();
    }

}
