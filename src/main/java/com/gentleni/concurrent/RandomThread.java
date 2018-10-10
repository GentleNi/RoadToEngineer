package com.gentleni.concurrent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * Created by GentleNi
 * Date 2018/9/28.
 */
public class RandomThread {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final List<Integer> randomList = new LinkedList<Integer>();
        final Random random = new Random();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 0;i < 1000;i++) {
            final int finalI = i;
            newFixedThreadPool.execute(new Runnable() {
                public void run() {
                    randomList.add(finalI);
                }
            });
        }
        newFixedThreadPool.shutdown();
        try {
            newFixedThreadPool.awaitTermination(1, TimeUnit.DAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long usedTime = endTime - startTime;
        System.out.println(usedTime);
        for (int j: randomList) {
            System.out.println(j);
        }
    }

}
