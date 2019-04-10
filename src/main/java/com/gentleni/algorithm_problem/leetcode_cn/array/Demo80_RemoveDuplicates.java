package com.gentleni.algorithm_problem.leetcode_cn.array;

/**
 * @Author GentleNi
 * @Date 2018-08-27 21:46
 **/

public class Demo80_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,4,4}; //return 7
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2;
        for (int j = 0;j < nums.length; j++ ) {
            if (nums[index-2] != nums[j]) {
                nums[index++] = nums[j];
            }
        }
        return index;
    }
}
