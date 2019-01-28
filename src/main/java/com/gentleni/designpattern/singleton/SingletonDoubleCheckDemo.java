package com.gentleni.designpattern.singleton;

/**
 * Created by GentleNi
 * Date 2019/1/28.
 */
public class SingletonDoubleCheckDemo {
    private static volatile SingletonDoubleCheckDemo INSTANCE;

    private SingletonDoubleCheckDemo(){}

    public static SingletonDoubleCheckDemo getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDoubleCheckDemo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDoubleCheckDemo();
                }
            }
        }
        return INSTANCE;
    }
}
