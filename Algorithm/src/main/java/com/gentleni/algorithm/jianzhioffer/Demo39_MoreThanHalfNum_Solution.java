package com.gentleni.algorithm.jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by GentleNi
 * Date 2019/2/19.
 */
public class Demo39_MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int result = nums[0];
        int count = 1;
        for (int i = 1;i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
            } else if (nums[i] != result) {
                count--;
            } else {
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Demo39_MoreThanHalfNum_Solution demo = new Demo39_MoreThanHalfNum_Solution();
        System.out.println(demo.MoreThanHalfNum_Solution(new int[]{1,1,1,1,1,1,2,3,4,4,4,5,6}));
    }
}
