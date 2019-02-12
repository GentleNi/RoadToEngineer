package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/11.
 */
public class Demo15_bitCount {

    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
}
