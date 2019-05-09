package com.gentleni.algorithm.leetcode_cn.array.Permutation;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GentleNi
 * Date 2019/4/17.
 */
public class Demo46_Permutations {
    // 最终返回的结果集
    List<String> res = new ArrayList<>();

    public List<String> permute(int[] nums) {
        if (nums.length == 0) return res;
        int len = nums.length;
        exchange(nums,0,len);
        return res;

    }

    private void exchange(int[] nums, int i, int len) {
        if (i == len - 1) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j <len; j++) {
                sb.append(nums[j]);
            }
            res.add(sb.toString());
            return;
        }
        // 将当前位置的数跟后面的数交换，并搜索解
        for (int j=i; j<len; j++) {
            swap(nums, i, j);
            exchange(nums, i+1, len);
            swap(nums, i, j);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        permute(new int[]{1,2,3});
        for (String s : res)
            System.out.println(s);
    }
}
