package com.gentleni.spring;

import java.util.NavigableMap;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
public class HelloWord {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello: " + name);
    }
}
