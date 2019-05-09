package com.gentleni.algorithm.cyc2018.dynamicprogram;

/**
 * Created by GentleNi
 * Date 2019/3/21.
 */
public class Demo03_IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i ;j++) {
                dp[i] = Math.max(dp[i],Math.max(j * dp[i - j],j * (i - j)));
            }
        }
        return dp[n];
    }
}
