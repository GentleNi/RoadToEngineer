package com.gentleni.algorithm.leetcode_cn.array;

import sun.print.SunMinMaxPage;

/**
 * Created by GentleNi
 * Date 2019/5/8.
 */
public class Demo209_MinSubArrayLen {

    public  int minSubArrayLen(int s, int[] nums) {
        int l=0,r=-1;//[i...j]为连续子数组,是我们的滑动窗口
        int sum=0;//子数组[i..j]的和
        int res=nums.length+1;
        while(l<nums.length){
            //滑动数组的和小于目标值，窗口右滑
            if(sum<s&&r+1<nums.length){
                r++;
                sum=sum+nums[r];
            }
            //滑动数组的和大于等于目标值，窗口左滑
            else{
                sum=sum-nums[l];
                l++;
            }
            //滑动数组的和大于等于目标值，获得最新的最小数组长度
            if(sum>=s){
                res=Math.min(res,r-l+1);
            }
        }
        if(res==nums.length+1)//没有解的情况
            return 0;
        else return res;
    }

}
