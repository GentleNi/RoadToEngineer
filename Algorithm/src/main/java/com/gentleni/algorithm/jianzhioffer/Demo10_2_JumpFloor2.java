package com.gentleni.algorithm.jianzhioffer;

import java.util.Arrays;

/**
 * Created by GentleNi
 * Date 2019/2/26.
 */
public class Demo10_2_JumpFloor2 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target;i++)
            for (int j = 0 ; j < i; j++ ) {
                dp[i] += dp[j];
        }
        return dp[target-1];
    }
}
