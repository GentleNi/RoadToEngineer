package com.gentleni.concurrent;

import java.util.ArrayList;

/**
 * Created by GentleNi
 * Date 2018/12/18.
 */
public class TestArrayList {
    static ArrayList<Integer> list = new ArrayList<>(10);
    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 2000000; i++){
                list.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list.size());
    }
}
