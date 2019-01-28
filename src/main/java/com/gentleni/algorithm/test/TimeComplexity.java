package com.gentleni.algorithm.test;

/**
 * Created by GentleNi
 * Date 2019/1/28.
 */
public class TimeComplexity {

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        Thread.sleep(1000);
        threadA.interrupt();

    }

}

class ThreadA extends Thread{

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            for (int i = 0; ; i++) {
                System.out.println(i);
            }
        }
        System.out.println("total in 1s");
    }
}
