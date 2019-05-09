package com.gentleni.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by GentleNi
 * Date 2018/11/9.
 */
public class ReentrantLockTimeoutDemo implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockTimeoutDemo td = new ReentrantLockTimeoutDemo();
        Thread t1 = new Thread(td);
        Thread t2= new Thread(td);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " Get lock");
                Thread.sleep(3000);
            } else {
                System.out.println(Thread.currentThread().getName() + " Get Lock Failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }
}
