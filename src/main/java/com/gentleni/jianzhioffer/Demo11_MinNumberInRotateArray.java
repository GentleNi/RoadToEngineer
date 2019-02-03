package com.gentleni.jianzhioffer;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by GentleNi
 * Date 2019/2/2.
 */
public class Demo11_MinNumberInRotateArray {

    //无重复数字的
    public static int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }

    //有重复数字
    public int minNumberInRotateArray2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h])
                return minNumber(nums, l, h);
            else if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }

    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{5,1,2,3,4}));
    }
}
