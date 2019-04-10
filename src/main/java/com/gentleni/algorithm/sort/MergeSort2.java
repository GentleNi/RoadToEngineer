package com.gentleni.algorithm.sort;

/**
 * Created by GentleNi
 * Date 2019/1/16.
 */
public class MergeSort2 {

    private static void mergeSort(int[] a, int l, int r) {
        //中止递归条件
        if (l >= r) return;
        //取中点
        int m = (l + r) / 2;
        //分治递归
        mergeSort(a,l,m);
        mergeSort(a,m+1,r);
        //合并a[l...m]和a[m+1...r]
        merge(a,l,m,r);


    }

    private static void merge(int[] a, int l, int m, int r) {
        int n = a.length;//数组长度
        int[] tmp = new int[n];

        int i = l;
        int j = m+1;
        int k = 0;

        while (i <= m && j <= r){
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        //判断哪个部分有剩余,先默认左部分有剩余
        int start = i;
        int end = m;
        if (i > m) { //则右边有剩余
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while(start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i < k; ++i) {
            a[l + i] = tmp[i];
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{11,8,3,9,7,1,2,5};
        mergeSort(array,0,array.length-1);
        SortUtils.printArray(array);
    }
}
