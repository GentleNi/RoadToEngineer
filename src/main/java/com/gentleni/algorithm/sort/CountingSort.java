package com.gentleni.algorithm.sort;

/**
 * Created by GentleNi
 * Date 2019/1/18.
 */
public class CountingSort {

    public void countingSort(int[] a,int n) {
        if (n <= 1) return;

        int max = 0;
        //查看数据范围
        for (int i = 0; i < n;i++) {
            if (a[i] > max)
                max = a[i];
        }

        int[] c = new int[max + 1]; //  申请一个计数数组 c ，下标大小 [0,max]

        //记录每个元素出现的次数
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        //依次累加
        for (int i = 1; i < n; i++) {
            c[i] = c[i-1] + c[i];
        }

        //  临时数组 r ，存储排序之后的结果
        int[] r = new int[n];
        //开始排序
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = c[a[i]];
            c[a[i]]--;
        }

        //  将结果拷贝给 a  数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }


    }
}
