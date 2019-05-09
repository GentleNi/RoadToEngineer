package com.gentleni.algorithm.basic.sort;

/**
 * Created by GentleNi
 * Date 2018/11/14.
 */
public class SelectionSort {

    public static void selectionSort(int[] a){
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] < a[minIndex])
                    minIndex = j;//找到每一趟最小值
            }
            //交换
            SortUtils.swap(a,i,minIndex);
        }
    }


    public static void main(String[] args) {
        int[] array = SortUtils.createRandomArray(10);
        selectionSort(array);
        SortUtils.printArray(array);
    }
}
