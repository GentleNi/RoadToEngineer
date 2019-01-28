package com.gentleni.jianzhioffer;

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
        
    }

}
