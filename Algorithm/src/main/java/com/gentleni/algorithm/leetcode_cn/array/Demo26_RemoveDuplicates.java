package com.gentleni.algorithm.leetcode_cn.array;

/**
 * @Author GentleNi
 * @Date 2018-08-27 21:32
 **/

public class Demo26_RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,2,2,4,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
