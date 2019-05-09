package com.gentleni.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by GentleNi
 * Date 2019/1/27.
 */
public class AtomicIntegerDemo {

    public static AtomicInteger i = new AtomicInteger(0);

    public static int unsafe_i = 0;

    public static void add() {
        i.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int m = 0; m < 10; m++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        add();
                    }
                }
            });
        }

        executor.shutdown();

        Thread.sleep(2000);
        System.out.println(i);
    }

}
