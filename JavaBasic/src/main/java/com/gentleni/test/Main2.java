package com.gentleni.test;

import java.math.BigInteger;

/**
 * Created by GentleNi
 * Date 2019/4/3.
 */
public class Main2 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("0000000001");
        BigInteger b = new BigInteger("999999999");
        System.out.println(a.multiply(b));
    }
}
