package com.gentleni.algorithm.cyc2018.dynamicprogram;

/**
 * Created by GentleNi
 * Date 2019/3/21.
 */
public class Demo01_ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int pre1 = 2,pre2 = 1;
        for (int i = 2; i < n; i ++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1= cur;
        }
        return pre1;
    }
}
