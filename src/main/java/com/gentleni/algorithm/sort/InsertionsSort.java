package com.gentleni.algorithm.sort;

/**
 * Created by GentleNi
 * Date 2018/11/15.
 */
public class InsertionsSort {

    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1;i < n;i++) {
            int key = a[i];//本次要插入的数
            int j = i-1;
            while (j >= 0 && a[j] > key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = SortUtils.createRandomArray(10);
        insertionSort(array);
        SortUtils.printArray(array);
    }
}
