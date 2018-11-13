package com.gentleni.thread;

/**
 * Created by GentleNi
 * Date 2018/10/12.
 */
public class TestInterruptThread {

    public static void main(String[] args) throws InterruptedException {
        final Thread t  = new Thread(new Runnable() {
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    for (int i = 0; i < 10000 ;i++) {
                        if (i > 8888) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                System.out.println("I 'm interrupt.");
                                break;
                            }
                        }
                        System.out.println(i);
                    }
                }
            }
        });
        t.start();
        Thread.sleep(10 * 1000);
        t.interrupt();
    }
}
