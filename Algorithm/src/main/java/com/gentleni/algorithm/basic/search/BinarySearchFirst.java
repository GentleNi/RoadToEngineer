package com.gentleni.algorithm.basic.search;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by GentleNi
 * Date 2019/1/22.
 */
public class BinarySearchFirst {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,2,3,4,4,5},4));
    }

    public static int binarySearch(int[] a,int value) {
        int length = a.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0 ) ||(a[mid - 1] != value))
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
