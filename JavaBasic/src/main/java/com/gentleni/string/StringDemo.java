package com.gentleni.string;

import org.omg.CORBA.INTERNAL;

/**
 * Created by GentleNi
 * Date 2019/1/14.
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hel";
        String s3 = "lo";
        String s4 = s2 + s3;
        String s5 = new String("hello");
        String s6 = new String("hello");
        System.out.println(Integer.toHexString(s1.hashCode()));
        System.out.println(Integer.toHexString(s2.hashCode()));
        System.out.println(Integer.toHexString(s3.hashCode()));
        System.out.println(Integer.toHexString(s4.hashCode()));
        System.out.println(Integer.toHexString(s5.hashCode()));
        System.out.println(s1 == s4);
        System.out.println(s1.equals(s2));
        System.out.println(s5 == s6);
    }
}
