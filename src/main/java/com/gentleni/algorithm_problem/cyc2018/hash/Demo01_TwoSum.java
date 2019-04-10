package com.gentleni.algorithm_problem.cyc2018.hash;

import java.util.HashMap;

/**
 * Created by GentleNi
 * Date 2019/3/27.
 */
public class Demo01_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexForNum.containsKey(target-nums[i])) {
                return new int[]{indexForNum.get(target - nums[i]), i};
            } else {
                indexForNum.put(nums[i], i);
            }
        }
        return null;
    }
}
