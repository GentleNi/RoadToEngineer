package com.gentleni.algorithm.search;

/**
 * Created by GentleNi
 * Date 2019/1/21.
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(birnarySearch(new int[]{1,3,4,5,6,9},9));
    }
    public static boolean birnarySearch(int[] a,int target) {
        int length = a.length;
        int low = 0;
        int high = length-1;
        while (low <= high) {
            int medium = low + (high - low) / 2;
            if (target == a[medium]) return true;
            else if (target > a[medium]) {
                low = medium + 1;
            } else if (target < a[medium]) {
                high = medium - 1;
            }
        }
        return false;
    }
}
