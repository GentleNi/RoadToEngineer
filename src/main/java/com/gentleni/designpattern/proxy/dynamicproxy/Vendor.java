package com.gentleni.designpattern.proxy.dynamicproxy;

/**
 * Created by GentleNi
 * Date 2019/3/1.
 */
public class Vendor implements Sell {

    @Override
    public void sell() {
        System.out.println("I'm Sell Method");
    }

    @Override
    public void ad() {
        System.out.println("I'm ad Method");
    }
}
