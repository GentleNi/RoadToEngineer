package com.gentleni.algorithm_problem.leetcode_cn.array;

/**
 * Created by GentleNi
 * Date 2019/4/16.
 */
public class Demo27_RemoveElements {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] == val) {
                continue;
            } else {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
