package com.gentleni.jianzhioffer;

import java.util.Currency;

/**
 * Created by GentleNi
 * Date 2019/2/11.
 */
public class ZDemo14_CuttingStringDynamic {
    private static int[] memo;
    private static int callCount = 0;

    //1.递归实现
    //10米的绳子，分解成Max( 1*f(9), 2*f(8),......,9*f(1))
    public static int cuttingStringDigui(int n) {
        if( n == 1)
            return 1;
        int result = -1;
        for (int i = 1; i <= n; i++) {
            result = max3(result,i * (n-i),i * cuttingStringDigui(n-i));
        }
        return result;
    }


    //2.记忆化搜索实现
    public static int cuttingStringMemo(int n) {
        callCount++;
        if( n == 1)
            return 1;

        if (memo[n] != 0)
            return memo[n];

        int result = -1;
        for (int i = 1; i <= n-1; i++) {
            result = max3(result,i * (n-i),i * cuttingStringMemo(n-i));
        }
        memo[n] = result;
        return result;
    }

    public static int cuttingStringMemoSearch(int n) {
        memo = new int[n+1];
        return cuttingStringMemo(n);
    }

    //3.动态规划
    public static int cuttingStringDymanic(int n) {
        if( n == 1)
            return 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= n-1; j++) {
                memo[i] = max3(memo[i],i * (n-i),i * memo[n-i]);
        }
        return memo[n];
    }

    private static int max3(int a, int b, int c) {
        return Math.max(a,Math.max(b,c));
    }

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        int result = cuttingStringMemoSearch(30);
        Long endTime = System.currentTimeMillis();
        System.out.println("The result is " + result +" " + (endTime - startTime) + "ms");
        System.out.println(callCount);

        startTime = System.currentTimeMillis();
        result = cuttingStringDigui(30);
        endTime = System.currentTimeMillis();
        System.out.println("The result is " + result +" " + (endTime - startTime) + "ms");
        System.out.println(callCount);

        startTime = System.currentTimeMillis();
        result = cuttingStringDymanic(30);
        endTime = System.currentTimeMillis();
        System.out.println("The result is " + result +" " + (endTime - startTime) + "ms");
        System.out.println(callCount);
    }
}
