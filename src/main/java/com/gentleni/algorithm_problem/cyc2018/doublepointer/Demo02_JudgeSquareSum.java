package com.gentleni.algorithm_problem.cyc2018.doublepointer;

/**
 * Created by GentleNi
 * Date 2019/3/21.
 */
public class Demo02_JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
