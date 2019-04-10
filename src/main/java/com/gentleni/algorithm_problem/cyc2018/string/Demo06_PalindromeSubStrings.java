package com.gentleni.algorithm_problem.cyc2018.string;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo06_PalindromeSubStrings {
    private int cnt = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length();i++) {
            extendSubstrings(s,i,i);
            extendSubstrings(s,i,i+1);
        }
        return cnt;
    }

    private void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }
}
