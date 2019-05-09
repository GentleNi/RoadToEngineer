package com.gentleni.thread;

/**
 * Created by GentleNi
 * Date 2018/11/9.
 */
public class WaitAndNotifyDemo {

    public static void main(String[] args) {
        final Object object = new Object();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (object) {
                        object.wait();
                    }
                    System.out.println("get up");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    synchronized (object) {
                        object.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        a.start();
        b.start();
    }

}
