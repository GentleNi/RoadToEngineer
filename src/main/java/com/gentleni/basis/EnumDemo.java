package com.gentleni.basis;

/**
 * Created by GentleNi
 * Date 2019/1/14.
 */
public class EnumDemo {
    enum size {SMALL,MEDIUM,LARGE};
    static size s = size.LARGE;

    public static void main(String[] args) {
        System.out.println(s);
    }
}
