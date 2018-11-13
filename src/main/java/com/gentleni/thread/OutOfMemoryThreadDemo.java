package com.gentleni.thread;

/**
 * Created by GentleNi
 * Date 2018/11/1.
 */
public class OutOfMemoryThreadDemo {
    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        //dont stop
                    }
                }
            }).start();
        }
    }
}
