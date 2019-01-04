package com.gentleni.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by GentleNi
 * Date 2018/12/19.
 */
public class ScheduleAtFixedRateDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    //Thread.sleep(1000);
                    Thread.sleep(5000);
                    System.out.println(System.currentTimeMillis()/1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,2, TimeUnit.SECONDS);
    }
}
