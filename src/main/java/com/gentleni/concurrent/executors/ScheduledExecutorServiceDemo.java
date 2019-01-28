package com.gentleni.concurrent.executors;

import sun.rmi.runtime.Log;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by GentleNi
 * Date 2019/1/27.
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException {
        //创建一个ScheduledThreadPoolExecutor对象
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        //计划在某段时间后运行
        System.out.println("Current Time = "+new Date());
        for(int i=0; i<3; i++){
            Thread.sleep(1000);
            WorkerThread worker = new WorkerThread("do heavy processing",countDownLatch);
            //创建并执行在给定延迟后启用的单次操作。
            scheduledThreadPool.schedule(worker, 3, TimeUnit.SECONDS);
        }

        countDownLatch.await();
        System.out.println("Current Time = " + new Date());
        //关闭线程池
        scheduledThreadPool.shutdown();

        System.out.println("Finished all threads");


    }
}
