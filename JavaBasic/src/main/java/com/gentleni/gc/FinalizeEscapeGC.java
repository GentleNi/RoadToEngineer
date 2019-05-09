package com.gentleni.gc;

/**
 * Created by GentleNi
 * Date 2018/9/14.
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOKE = null;

    public void isAlive() {
        System.out.println("I'm still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        SAVE_HOKE = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOKE = new FinalizeEscapeGC();

        SAVE_HOKE = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOKE != null) {
            SAVE_HOKE.isAlive();
        } else {
            System.out.println("I'm dead");
        }

        //finalize method can only be executed once , so self cute failed

        SAVE_HOKE = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOKE != null) {
            SAVE_HOKE.isAlive();
        } else {
            System.out.println("I'm dead");
        }

    }
}
