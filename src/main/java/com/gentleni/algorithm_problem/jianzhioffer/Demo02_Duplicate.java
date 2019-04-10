package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/1/4.
 */
public class Demo02_Duplicate {


    //1.利用数组做一个hash，时间复杂度o(n),空间复杂度o(n)
    public static int getRepeatedNum1(int[] a) {
        if (a == null || a.length == 0)
            return -1;
        //检查数据条件
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] < 0 || a[i] > a.length - 1)
                return -1;
        }

        int[] hashtable = new int[a.length];
        for (int num : a) {
            if (hashtable[num] >= 1) {
                return num;
            } else {
                hashtable[num] = 1;
            }
        }
        return -1;
    }


    //2. 根据数字特点排序，会修改原始数据，时间复杂度o(n),空间复杂度o(1)
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {//依次对下标进行比较
                if (nums[i] == nums[nums[i]]) {//如果nums[i] 和 num i 不相等的情况下，并且nums[i] == nums[nums[i]],返回重复
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);//否则进行交换
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
