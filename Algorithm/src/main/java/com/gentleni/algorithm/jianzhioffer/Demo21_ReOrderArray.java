package com.gentleni.algorithm.jianzhioffer;


import java.util.Arrays;

/**
 * Created by GentleNi
 * Date 2019/2/14.
 */
public class Demo21_ReOrderArray {

    public static void reOrderArray(int[] a ) {
        if (null == a || a.length <= 0)
            return;
        int start = 0;
        int end = a.length-1;
        while (start < end) {
            while (start < end && a[start] % 2 != 0) {
                start++;
            }
            while (start < end && a[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,4,3,5,8,7,1};
        reOrderArray(a);
        System.out.println(Arrays.toString(a));
    }
}
