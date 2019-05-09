package com.gentleni.algorithm.leetcode_cn.array;

import java.util.HashMap;

/**
 * Created by GentleNi
 * Date 2019/4/16.
 */
public class Demo01_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            myMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            final Integer v = myMap.get(target-nums[i]);
            if (v != null && v > i) {
                return new int[]{i+1, v+1};
            }
        }
        return null;
    }
}
