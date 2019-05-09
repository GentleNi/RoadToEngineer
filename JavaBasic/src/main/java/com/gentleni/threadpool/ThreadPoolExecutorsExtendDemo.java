package com.gentleni.threadpool;

import java.util.concurrent.*;

/**
 * Created by GentleNi
 * Date 2018/12/19.
 */
public class ThreadPoolExecutorsExtendDemo {
    public static class MyTask implements Runnable{
        String name;
        MyTask(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println("Running" + "Thread ID: " +Thread.currentThread().getId() +
                    "Thread Name " +Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = new ThreadPoolExecutor(5,
                5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("Ready for execute " + Thread.currentThread().getName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("After execute " + Thread.currentThread().getName());
            }

            @Override
            protected void terminated() {
                System.out.println("Exit");
            }
        };

        for (int i = 0; i < 5; i++) {
            MyTask task = new MyTask("TASK-NAME-" + i);
            service.execute(task);
            Thread.sleep(10);
        }
        service.shutdown();
    }
}
