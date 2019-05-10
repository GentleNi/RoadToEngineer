package com.gentleni.algorithm.leetcode_cn.array.window;

/**
 * Created by GentleNi
 * Date 2019/5/9.
 */
public class Demo03_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0, r = -1;
        int res = 0;

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r+1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
