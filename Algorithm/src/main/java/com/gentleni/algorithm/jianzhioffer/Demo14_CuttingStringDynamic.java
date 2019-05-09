package com.gentleni.algorithm.jianzhioffer;

import java.util.Currency;

/**
 * Created by GentleNi
 * Date 2019/2/11.
 */
public class Demo14_CuttingStringDynamic {
    private static int[] memo;
    private static int callCount = 0;

    /**
     * 没有错误，当length<=3的时候，我们直接返回了结果。如果整个绳子的长度为3，我们必须把绳子剪开，因为题目要求m>1，其中一段为2，另一段为1，这样结果就是2。
     　　　　　当length>=4的时候，我们可以把绳子剪成两段，其中一段为3另一段为１，这样长度为3的那一段的最大值就是3而不是2，因为这一段我们不需要再剪了。当然长度为4的最大值是2和2的组合，我们已经存储了2的长度。
     * @param length
     * @return
     */
    public static int maxAfterCutting(int length){
        if(length<2)
            return 0;
        if(length==2)
            return 1;
        if(length==3)
            return 2;
        // 子问题的最优解存储在f数组中，数组中的第i个元素表示把长度为i的绳子剪成若干段后各段长度乘积的最大值。
        int[] f = new int[length+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        int result = 0;
        for(int i = 4;i<=length;i++){
            int max = 0;
            for(int j = 1;j<=i/2;j++){
                int num = f[j]*f[i-j];
                if(max<num)
                    max = num;
                f[i] = max;
            }
        }
        result = f[length];
        return result;
    }

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
