package com.gentleni.test;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

/**
 * Created by GentleNi
 * Date 2019/4/8.
 */
// 2 /order/pnrList/pnrPriceList /order/pnrList/pnrPriceList/
public class Test {
    public static void main(String[] args) {
        Test test = null;
        test.print();
        ((Test)test).print();
        ((Test)null).print();
    }

    public static void print() {
        System.out.println("hello world");
    }
}
