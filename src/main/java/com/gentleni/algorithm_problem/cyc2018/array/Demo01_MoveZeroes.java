package com.gentleni.algorithm_problem.cyc2018.array;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo01_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num: nums) {
            if (num != 0)
                nums[index++] = num;
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
