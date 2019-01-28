package com.gentleni.thread;

import sun.java2d.loops.GraphicsPrimitive;

/**
 * Created by GentleNi
 * Date 2019/1/27.
 */
public class InterruptDemo {

    public static void main(String[] args) {
        final Object object = new Object();

        final ThreadA threadA = new ThreadA();
        threadA.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("interrupt A ...");
                    threadA.interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }).start();
    }


}

 class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            int i = 0;
            System.out.println("wait for interrupt....");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("interrupt");
        }
    }
}