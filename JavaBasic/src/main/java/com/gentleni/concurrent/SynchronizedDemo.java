package com.gentleni.concurrent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by GentleNi
 * Date 2018/9/28.
 */
public class SynchronizedDemo {

    static List<Integer> nums = new LinkedList<Integer>();
    static int num = 0;

    public  synchronized static void add1() {
        nums.add(++num);
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        long startTime = System.currentTimeMillis();
        executorService.execute(new Add1Thread());
        executorService.execute(new Add2Thread());
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        for (int i = 0;i< nums.size();i++) {
//            System.out.println(i);
//        }

        System.out.println("The nums size is "+nums.size());
        long endTime = System.currentTimeMillis();
        long usedTime = endTime - startTime;
        System.out.println("Total use time is " + usedTime + "ms");
    }

    static class Add1Thread implements Runnable {

        public void run() {
            for (int i = 0;i < 10000000;i++) {
                add1();
            }
        }
    }

    static class Add2Thread implements Runnable {

        public void run() {
            for (int i = 0;i < 10000000;i++) {
                add1();
            }
        }
    }



}
