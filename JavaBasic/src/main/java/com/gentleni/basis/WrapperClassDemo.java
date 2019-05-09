package com.gentleni.basis;

/**
 * Created by GentleNi
 * Date 2019/1/14.
 */
public class WrapperClassDemo {

    public static void main(String[] args) {

        Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.print(i == j); //false

        Integer i2 = new Integer(100);
        int j2 = 100;
        System.out.print(i2 == j2); //true

        //测试创建时间

        long startTime = System.currentTimeMillis();
        for (int m = 0; m < 100000000; m++) {
            Integer integer = new Integer(12222);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间： " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int m = 0; m < 100000000; m++) {
            int h = 1222222;
        }
        endTime = System.currentTimeMillis();
        System.out.println("消耗时间： " + (endTime - startTime));

        //缓存
        System.out.println(Boolean.valueOf(true) == Boolean.valueOf(true));
        System.out.println(new Boolean(true) == new Boolean(true));
    }
}
