package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/25.
 */
public class Demo65_Sum {

    public int add(int a,int b) {
        int sum,carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while (b != 0);
        return a;
    }
}
