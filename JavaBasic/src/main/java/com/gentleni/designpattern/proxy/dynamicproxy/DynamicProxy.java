package com.gentleni.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by GentleNi
 * Date 2019/3/1.
 */
public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(object, args);
        System.out.println("after");
        return result;
    }
}
