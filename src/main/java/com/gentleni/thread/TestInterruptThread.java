package com.gentleni.thread;

/**
 * Created by GentleNi
 * Date 2018/10/12.
 */
public class TestInterruptThread {

    public static void main(String[] args) {
        Thread t  = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000 ;i++) {
                    if (i > 8888) {
                        try {
                            Thread.sleep(10000);
                            Thread.currentThread().interrupt();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (Thread.interrupted())
                        break;
                    System.out.println(i);
                }
            }
        });
        t.start();
    }
}
