package com.gentleni.algorithm.cyc2018.bit;

/**
 * Created by GentleNi
 * Date 2019/3/27.
 */
public class Demo05_IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
