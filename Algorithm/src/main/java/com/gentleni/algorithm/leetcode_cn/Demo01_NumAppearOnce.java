package com.gentleni.algorithm.leetcode_cn;

/**
 * Created by GentleNi
 * Date 2019/3/17.
 */
public class Demo01_NumAppearOnce {

    public int singleNumber(int[] nums) {
        int len = nums.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
