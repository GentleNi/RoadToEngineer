package com.gentleni.algorithm_problem.jianzhioffer;

import com.gentleni.concurrent.SynchronizedDemo;
import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by GentleNi
 * Date 2019/1/28.
 */
public class Demo01_Singleton {

    /**
     * 饿汉式，线程安全。在单例类被加载时候，就实例化一个对象并交给自己的引用
     * static和final保证初始化时的安全性
     */
    public static class Singleton {
        private final static Singleton INSTANCE = new Singleton();
        private Singleton(){}

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 懒汉式，在真正需要时候才进行实例化。线程安全，多线程环境下效率不高
     */
    public static class Singleton2 {
        private static Singleton2 INSTANCE = null;
        private Singleton2(){}

        public synchronized Singleton2 getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Singleton2();
            }
            return INSTANCE;
        }
    }


    /**
     * 单例模式，懒汉式，使用静态内部类，线程安全【推荐】
     */
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }

        private Singleton5() {

        }

        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }

    }

    /**
     * 静态内部类，使用双重校验锁，线程安全【推荐】
     */
    public static class Singleton7 {
        private volatile static Singleton7 instance;
        private Singleton7(){}

        public static Singleton7 getInstance() {
            if (instance == null) {
                synchronized (Singleton7.class) {
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 强烈推荐
     */
    public enum Singleton8 {
        INSTANCE;
        public void whateverMethod() {
        }
    }

}
