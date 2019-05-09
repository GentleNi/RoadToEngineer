package com.gentleni.basis;

/**
 * Created by GentleNi
 * Date 2018/12/18.
 */
public class IntegerOverFlow {
    public static void main(String[] args) {
        int a = 1073741827;
        int b = 1431655768;
        System.out.println(a+b);
        System.out.println(Integer.MAX_VALUE);
    }
}
