package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/23.
 */
public class Demo63_MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int soFarMin = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i] - soFarMin);
        }
        return maxProfit;
    }
}
