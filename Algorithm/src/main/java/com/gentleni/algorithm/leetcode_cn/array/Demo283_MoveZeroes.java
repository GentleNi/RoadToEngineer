package com.gentleni.algorithm.leetcode_cn.array;

/**
 * Created by GentleNi
 * Date 2019/4/17.
 */
public class Demo283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}
