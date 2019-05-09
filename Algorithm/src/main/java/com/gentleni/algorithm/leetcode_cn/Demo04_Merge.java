package com.gentleni.algorithm.leetcode_cn;

/**
 * Created by GentleNi
 * Date 2019/3/17.
 */
public class Demo04_Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m>0 && n>0){
            if(nums1[m-1]> nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        //nums1插完，需要把nums2数据插入。
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i] = nums2[i];
            }
        }
    }
}
