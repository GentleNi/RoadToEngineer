package com.gentleni.algorithm.leetcode_cn.array;

/**
 * Created by GentleNi
 * Date 2019/5/6.
 */
public class Demo215_KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int pos = parpition(nums,start,end);
            if (pos == k-1)
                break;
            else if (pos < k-1) {
                start = pos + 1;
            } else {
                end = pos -1;
            }
        }
        return nums[k-1];
    }



    //从大到小排列
    public int parpition(int[] arr, int left, int right) {
        int temp = arr[left];//基数
        while (left < right) {
            // 先判断基准数和后面的数依次比较
            while (temp >= arr[right] && left < right) {
                right--;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                left++;//基准坐标右移
            }
            //从左向右找第一个比temp小的
            while (temp <= arr[left] && left < right) {
                left++;
            }
            //填坑右边的
            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = temp;
        return left;
    }
}
