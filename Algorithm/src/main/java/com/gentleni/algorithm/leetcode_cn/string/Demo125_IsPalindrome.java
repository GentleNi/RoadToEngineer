package com.gentleni.algorithm.leetcode_cn.string;

/**
 * Created by GentleNi
 * Date 2019/5/6.
 */
public class Demo125_IsPalindrome {
    public boolean isPalindrome(String s) {
        s = s.trim();
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) left++;
            else if (!Character.isLetterOrDigit(s.charAt(right))) right++;
            else if (s.charAt(left) != s.charAt(right)) return false;
            else {
                left++;
                right++;
            }
        }
        return true;
    }
}
