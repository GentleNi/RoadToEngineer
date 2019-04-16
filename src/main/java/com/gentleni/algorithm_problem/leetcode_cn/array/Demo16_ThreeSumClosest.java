package com.gentleni.algorithm_problem.leetcode_cn.array;

import java.util.Arrays;

/**
 * Created by GentleNi
 * Date 2019/4/16.
 */
public class Demo16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; ++i) {
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                final int sum = nums[i] + nums[j] + nums[k];
                final int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    result = sum;
                    minGap = gap;
                }

                if (sum < target) ++j;
                else              --k;
            }
        }
        return result;
    }
}
