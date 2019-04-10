package com.gentleni.algorithm_problem.cyc2018.string;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo03_IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
