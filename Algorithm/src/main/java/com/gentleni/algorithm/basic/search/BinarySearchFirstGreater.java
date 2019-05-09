package com.gentleni.algorithm.basic.search;

/**
 * Created by GentleNi
 * Date 2019/1/22.
 */
public class BinarySearchFirstGreater {

    public static int binarySearch(int[] a,int value) {
        int length = a.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] >= value) {
                if ((mid == 0) || a[mid-1] < value)
                    return mid;
                else high = mid -1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}
