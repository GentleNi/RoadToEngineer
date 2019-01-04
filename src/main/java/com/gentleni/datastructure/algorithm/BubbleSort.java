package com.gentleni.datastructure.algorithm;

/**
 * Created by GentleNi
 * Date 2018/11/14.
 */
public class BubbleSort {

    public static void bubbleSort (int[] a) {
        int size = a.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (a[j] > a[j+1])
                    SortUtils.swap(a,j,j+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = SortUtils.createRandomArray(10);
        bubbleSort(array);
        SortUtils.printArray(array);
    }
}
