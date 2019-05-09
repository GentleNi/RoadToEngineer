package com.gentleni.algorithm.jianzhioffer;

import java.time.chrono.MinguoChronology;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 */
public class Demo53_GetNumberOfK {

    public int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length-1);
        int lastK = getLastK(array, k, 0, length-1);
        if(firstK != -1 && lastK != -1){
            return lastK - firstK + 1;
        }
        return 0;
    }

    private int getLastK(int[] array, int k, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if(array[mid] > k){
            return getFirstK(array, k, start, mid-1);
        }else if (array[mid] < k){
            return getFirstK(array, k, mid+1, end);
        }else if(mid+1 <= end && array[mid+1] == k){
            return getFirstK(array, k, mid+1, end);
        }else{
            return mid;
        }

    }

    private int getFirstK(int [] array , int k, int start, int end){
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (k > array[mid]) {
                start = mid + 1;
            } else if (k < array[mid]) {
                end = mid - 1;
            } else {//相等的情况下
                if (mid > 0 && array[mid - 1] != k || mid == 0) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
