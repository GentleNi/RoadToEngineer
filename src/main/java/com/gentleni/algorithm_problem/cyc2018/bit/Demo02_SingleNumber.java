package com.gentleni.algorithm_problem.cyc2018.bit;

/**
 * Created by GentleNi
 * Date 2019/3/27.
 */
public class Demo02_SingleNumber {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) ret = ret ^ n;
        return ret;
    }
}
