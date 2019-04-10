package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/25.
 */
public class Demo66_Multiply {


    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        int product = 1;
        for (int i = 0;i < n;i++) {
            product *= A[i];
            B[i] = product;
        }

        product = 1;
        for (int i = n-1;i >= 0;i--) {
            product *= A[i];
            B[i] *= product;
        }
        return B;
    }
}
