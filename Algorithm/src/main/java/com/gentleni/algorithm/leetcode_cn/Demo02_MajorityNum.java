package com.gentleni.algorithm.leetcode_cn;

/**
 * Created by GentleNi
 * Date 2019/3/17.
 */
public class Demo02_MajorityNum {
    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == maj)
                count++;
            else {
                if (count == 0) {
                    maj = nums[i];
                } else {
                    count--;
                }
            }
        }
        return maj;
    }
}
