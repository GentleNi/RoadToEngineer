package com.gentleni.algorithm_problem.cyc2018.array;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo02_FindMaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] == 1) {
                curr++;
            } else {
                curr = 0;
            }
            max = Math.max(curr,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,1,1,3,4,5,2,1,1,2,1,1,1,1,1,1,1,1}));
    }
}
