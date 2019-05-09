package com.gentleni.threadpool;

import org.omg.CORBA.INTERNAL;

import java.util.concurrent.*;

/**
 * Created by GentleNi
 * Date 2018/12/19.
 */
public class RejectThreadPoolDemo {
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread ID: " +Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        ExecutorService service = new ThreadPoolExecutor(5,
                5, 0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + "is rejected");
            }
        });

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.submit(task);
            Thread.sleep(1000);
        }
    }
}
