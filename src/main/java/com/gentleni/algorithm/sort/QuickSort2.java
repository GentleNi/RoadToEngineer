package com.gentleni.algorithm.sort;

import java.net.SocketException;
import java.util.Arrays;

/**
 * Created by GentleNi
 * Date 2019/3/13.
 */
public class QuickSort2 {
    static void sort(int arr[], int low, int high)
    {

        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    public static int partition(int[] arr,int low,int high) {
        int i = low,j = high + 1;
        while (true) {
            while (arr[++i] < arr[low] && i < high);
            while (arr[--j] > arr[low] && j > low);
            if (i >= j) {
                break;
            }
            swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] array = SortUtils.createRandomArray(10);
        sort(array,0,array.length - 1);
        SortUtils.printArray(array);
    }
}
