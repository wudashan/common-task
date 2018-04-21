package com.wudashan;

import com.wudashan.task.DemoTask;
import com.wudashan.task.Task;

/**
 * 主程序
 */
public class Main {

    public static void main(String[] args) {
        Task task = new DemoTask("Demo");
        task.execute();
    }

}
