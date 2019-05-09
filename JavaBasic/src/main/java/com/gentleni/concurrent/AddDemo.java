package com.gentleni.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by GentleNi
 * Date 2018/10/12.
 */
public class AddDemo {

    public static void main(String[] args) throws InterruptedException {
        Num num  = new Num();
        AddThread a1 = new AddThread(num);
        AddThread a2 = new AddThread(num);
        a1.start();
        a2.start();
        a1.join();
        a2.join();
        System.out.println(num.num);
    }


}

class AddThread extends Thread {

    private Num num;

    public AddThread(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            num.num++;
        }
    }
}

class Num {
    int num = 0;
}