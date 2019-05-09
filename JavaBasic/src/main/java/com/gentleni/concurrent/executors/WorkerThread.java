package com.gentleni.concurrent.executors;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by GentleNi
 * Date 2019/1/27.
 */
public class WorkerThread  implements Runnable{
    private String command;
    private CountDownLatch countDownLatch;

    public WorkerThread(String s, CountDownLatch countDownLatch) {
        this.command = s;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
        countDownLatch.countDown();
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }

}
