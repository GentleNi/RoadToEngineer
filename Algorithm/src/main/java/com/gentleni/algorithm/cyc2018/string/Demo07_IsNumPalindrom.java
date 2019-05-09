package com.gentleni.algorithm.cyc2018.string;

/**
 * Created by GentleNi
 * Date 2019/3/27.
 */
public class Demo07_IsNumPalindrom {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }

        return x == right || x == right/10;
    }
}
