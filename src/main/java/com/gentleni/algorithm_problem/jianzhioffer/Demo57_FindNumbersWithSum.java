package com.gentleni.algorithm_problem.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 */
public class Demo57_FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum)
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            if (cur < sum)
                i++;
            else
                j--;
        }
        return new ArrayList<>();
    }
}
