package com.gentleni.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by GentleNi
 * Date 2018/10/28.
 */
public class CountDownLatchDemo {
    public static final int PLAYER_NUM = 5;


    public static void main(String[] args) {

        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);

        for (int i = 0; i < PLAYER_NUM; i++) {
            Player p = new Player(i,start,end);
            new Thread(p).start();
        }

        start.countDown();
        System.out.println("competition start");
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("competition accomplished");
    }

}

class Player implements Runnable {

    private int num;
    private CountDownLatch start;
    private CountDownLatch end;

    Player(int num, CountDownLatch start, CountDownLatch end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            start.await();
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("I'm player " + num + ", I'm finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            end.countDown();
        }
    }
}