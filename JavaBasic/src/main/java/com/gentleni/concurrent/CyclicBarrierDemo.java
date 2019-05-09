package com.gentleni.concurrent;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by GentleNi
 * Date 2018/11/6.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有的线程都完成工作");
            }
        });

        for (int i = 0; i < 4; i++) {
          new Thread(new Writer(cyclicBarrier)).start();
        }

    }

    static class Writer implements Runnable {
        private CyclicBarrier c ;

        Writer(CyclicBarrier c) {
            this.c = c;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
