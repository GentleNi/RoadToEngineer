package com.gentleni.concurrent;

import java.security.spec.ECField;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by GentleNi
 * Date 2018/11/9.
 */
public class SemaphoreDemo implements Runnable{
    final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " done ");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        for (int i = 0; i < 20 ;i++){
            executorService.submit(semaphoreDemo);
        }
    }
}
