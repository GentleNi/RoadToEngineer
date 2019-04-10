package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/1/31.
 */
public class Demo10_Fibonacci {

    //空间复杂度为n
    public int fibonacci(int n) {
        if (n <=1)
            return n;
        int[] arr = new int[n+1];
        arr[1] = 1;
        for (int i = 2; i <= n;i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    //空间复杂度O(1)
    public int fibonacci2(int n) {
        if (n <= 1)
            return n;
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <=n;i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }


}
