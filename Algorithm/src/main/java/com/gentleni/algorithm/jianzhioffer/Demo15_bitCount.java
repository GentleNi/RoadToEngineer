package com.gentleni.algorithm.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/11.
 */
public class Demo15_bitCount {

    //不直接右n了，而是左移flag
    public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((flag & n) != 0)
                count++;
            flag <<= 1;
        }
        return count;
    }

    //每次进位和1与
    public int NumberOf2 (int n) {
        int count = 0;
        while(n > 0) {
            if ((n & 1) > 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 9;
        System.out.println(new Demo15_bitCount().NumberOf1(8));
        System.out.println(new Demo15_bitCount().NumberOf2(8));
    }
}
