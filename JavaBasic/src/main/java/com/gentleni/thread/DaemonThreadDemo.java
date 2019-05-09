package com.gentleni.thread;

/**
 * Created by GentleNi
 * Date 2018/11/9.
 */
public class DaemonThreadDemo {

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("I'm still alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        DaemonThread d = new DaemonThread();
        d.setDaemon(true);
        d.start();

        d.join(2000);
    }
}
