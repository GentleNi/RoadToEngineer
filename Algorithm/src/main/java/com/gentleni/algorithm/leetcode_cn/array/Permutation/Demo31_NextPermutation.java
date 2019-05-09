package com.gentleni.algorithm.leetcode_cn.array.Permutation;

/**
 * Created by GentleNi
 * Date 2019/4/17.
 */
public class Demo31_NextPermutation {

    public void nextPermutation(int[] nums) {
        nextPermutation(nums, 0, nums.length);
    }
    private static boolean nextPermutation(int[] nums, int begin, int end) {

        //找到末尾的递减序列的前一个数字changeNumber，比如 5876返回5的index，5678返回7的index
        int p = end - 2;
        while (p > -1 && nums[p] >= nums[p + 1]) --p;

        //说明已经是递减序列，也就是全排列的最后一个序列，直接反转
        if(p == -1) {
            reverse(nums, begin, end);
            return false;
        }

        //从后往前找到第一个比changeNumber大的数字
        int c = end - 1;
        while (c > 0 && nums[c] <= nums[p]) --c;

        // Swap the partitionNumber and changeNumber
        swap(nums, p, c);
        // Reverse all the digits on the right of partitionNumber
        reverse(nums, p+1, end);
        return true;
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private static void reverse(int[] nums, int begin, int end) {
        end--;
        while (begin < end) {
            swap(nums, begin++, end--);
        }
    }
}
