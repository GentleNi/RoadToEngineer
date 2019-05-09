package com.gentleni.algorithm.cyc2018.doublepointer;

/**
 * Created by GentleNi
 * Date 2019/3/21.
 */
public class Demo01_TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
