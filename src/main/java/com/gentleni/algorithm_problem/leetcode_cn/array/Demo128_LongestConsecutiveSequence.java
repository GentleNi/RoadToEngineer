package com.gentleni.algorithm_problem.leetcode_cn.array;

import java.util.HashSet;

/**
 * Created by GentleNi
 * Date 2019/4/16.
 */
public class Demo128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        final HashSet<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        int longest = 0;

        for (int i : nums) {
            int length = 1;
            for (int j = i - 1; set.contains(j); j--) {
                set.remove(j);
                length++;
            }

            for (int j = i + 1; set.contains(j); ++j) {
                set.remove(j);
                ++length;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }

}