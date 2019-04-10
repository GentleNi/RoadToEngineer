package com.gentleni.thread;

import org.junit.runner.RunWith;

import javax.sound.midi.Soundbank;

/**
 * Created by GentleNi
 * Date 2019/3/20.
 */
public class CyclicPrintAB {

    public static void main(String[] args) throws InterruptedException {
        CyclicPrintAB lock = new CyclicPrintAB();
        ThreadAA a = new ThreadAA(lock);
        ThreadBB b = new ThreadBB(lock);
        new Thread(a).start();

        new Thread(b).start();
    }
}

class ThreadAA implements Runnable{

    private Object lock;
    public ThreadAA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                try {
                    System.out.println("A");
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

class ThreadBB implements Runnable {
    private Object lock;
    public ThreadBB(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                try {
                    System.out.println("B");
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
