package com.gentleni.algorithm.cyc2018.bit;

/**
 * Created by GentleNi
 * Date 2019/3/27.
 */
public class Demo01_HammingDistance {
    public static void main(String[] args) {
        int x = 1;
        int y = 5;
        System.out.println(x ^ y);
    }

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            if ((z & 1) == 1)
                count++;
        }
        return count;
    }
}
