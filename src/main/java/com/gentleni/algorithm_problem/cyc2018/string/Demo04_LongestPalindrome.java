package com.gentleni.algorithm_problem.cyc2018.string;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo04_LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c] ++;
        }
        int count = 0;
        for (int cnt: cnts) {
            count += (cnt / 2) * 2;
        }

        if (count < s.length()) {
            count++;
        }
        return count;
    }
}
