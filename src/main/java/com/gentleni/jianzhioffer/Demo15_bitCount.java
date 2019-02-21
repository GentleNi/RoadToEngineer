package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/11.
 */
public class Demo15_bitCount {

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

    public static void main(String[] args) {
        int a = 9;
        System.out.println(new Demo15_bitCount().NumberOf1(8));
    }
}
