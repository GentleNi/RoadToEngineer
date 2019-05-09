package com.gentleni.algorithm.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by GentleNi
 * Date 2019/3/22.
 */
public class Demo40_2_TopKMinNuM {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0)
            return ret;
        findKthSmallest(nums, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++)
            ret.add(nums[i]);
        return ret;
    }

    private void findKthSmallest(int[] nums, int k) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int j = partition(nums,l,h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }

    private int partition(int[] nums, int l, int h) {
        int pivot = nums[l];
        int i = l+1;
        int j = h;
        while (true) {
            while (i < h && nums[i] < pivot)
                i++;
            while (j > l && nums[j] > pivot)
                j--;
            if (i >= j)
                break;
            swap(nums,i,j);
        }
        swap(nums, l, j);
        return j;
    }

//    private int partition(int[] nums, int l, int h) {
//        int p = nums[l];     /* 切分元素 */
//        int i = l, j = h + 1;
//        while (true) {
//            while (i != h && nums[++i] < p) ;
//            while (j != l && nums[--j] > p) ;
//            if (i >= j)
//                break;
//            swap(nums, i, j);
//        }
//        swap(nums, l, j);
//        return j;
//    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new Demo40_2_TopKMinNuM().GetLeastNumbers_Solution(new int[]{8, 3, 4, 2, 7, 1}, 3);
        for(int i : list)
            System.out.println(i);
    }
}
