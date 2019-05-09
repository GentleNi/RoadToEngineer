package com.gentleni.algorithm.cyc2018.bit;

/**
 * Created by GentleNi
 * Date 2019/3/27.
 */
public class Demo04_SwapTwoNums {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
    }
}
