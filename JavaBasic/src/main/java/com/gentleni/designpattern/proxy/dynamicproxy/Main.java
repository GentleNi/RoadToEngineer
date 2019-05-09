package com.gentleni.designpattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by GentleNi
 * Date 2019/3/1.
 */
public class Main {

    public static void main(String[] args) {
        //创建中介类实例
        DynamicProxy inter = new DynamicProxy(new Vendor());
        //创建代理类实例
        Sell sell = (Sell) Proxy.newProxyInstance(Sell.class.getClassLoader(),new Class[]{Sell.class},inter);
        sell.sell();
        sell.ad();
    }
}
