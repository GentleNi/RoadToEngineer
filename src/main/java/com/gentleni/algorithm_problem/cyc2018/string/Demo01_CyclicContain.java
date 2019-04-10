package com.gentleni.algorithm_problem.cyc2018.string;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo01_CyclicContain {

    public boolean contains(String s1, String s2) {
        return (s1+s2).contains(s2);
    }
}
