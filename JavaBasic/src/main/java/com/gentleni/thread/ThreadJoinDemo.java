package com.gentleni.thread;

/**
 * Created by GentleNi
 * Date 2018/10/16.
 */
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            public void run() {
                for (int i = 0;i < 100; i++) {
                    System.out.println(i);
                }
            }
        });
        a.start();
        a.join();
        for (int i = 100;i < 200; i++) {
            System.out.println(i);
        }
    }

}
