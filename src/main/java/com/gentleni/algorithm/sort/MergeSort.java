package com.gentleni.algorithm.sort;

import java.util.Arrays;

/**
 * Created by GentleNi
 * Date 2018/11/15.
 */
public class MergeSort {

    static int step = 1;

    public static void merge(int[] arr,int l, int m, int r) {
        int n1 = m - l + 1; //size of left arr
        int n2 = r - m;//size of right arr

        //create arrays that about to merge
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0,j = 0;
        int k = l;

        //选择两个子数组头小的那个加入排序数组
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //加入子数组剩下的(肯定只有其中一个有剩余)

        while (i < n1) {
            arr[k] = L[i];
            k++;
            i++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public static void sort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r)/2;
            sort(a,l,m);
            sort(a,m+1,r);

            merge(a,l,m,r);
            System.out.println("step: " + (step++));
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{11,8,3,9,7,1,2,5};
        sort(array,0,array.length-1);
        SortUtils.printArray(array);
    }

}
