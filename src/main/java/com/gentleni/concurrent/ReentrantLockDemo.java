package com.gentleni.concurrent;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by GentleNi
 * Date 2018/10/12.
 */
public class ReentrantLockDemo {
    private int i = 0;

    private Lock reenTrantLock = new ReentrantLock();

    public  void add() {
        reenTrantLock.lock();
        for (int j = 0 ; j < 10000; j++)
            System.out.println(++i);
        reenTrantLock.unlock();
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) {
        final ReentrantLockDemo r = new ReentrantLockDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    r.add();
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i: " + r.getI());
    }

    class Num {
        int num = 0;
    }
}
