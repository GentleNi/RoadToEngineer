package com.gentleni.concurrent;

import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by GentleNi
 * Date 2018/10/12.
 */
public class ReentrantLockDemo {
    private int i = 0;
    private Lock reenTrantLock = new ReentrantLock();
    private CountDownLatch countDownLatch;

    public ReentrantLockDemo (CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public  void add() {
        reenTrantLock.lock();
        for (int j = 0 ; j < 10000; j++)
            System.out.println(++i);
        countDownLatch.countDown();
        reenTrantLock.unlock();
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) {
        final CountDownLatch count = new CountDownLatch(10);
        final ReentrantLockDemo r = new ReentrantLockDemo(count);

        for (int i = 0; i < 10; i++) {
            ThreadA threadA = new ThreadA(r);
            threadA.start();
        }

        try {
            System.out.println("wait.............");
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i: " + r.getI());
    }

}

class ThreadA extends Thread {

    ReentrantLockDemo reentrantLockDemo;

    public ThreadA(ReentrantLockDemo reentrantLockDemo) {
        this.reentrantLockDemo = reentrantLockDemo;
    }

    @Override
    public void run() {
        reentrantLockDemo.add();
    }
}
