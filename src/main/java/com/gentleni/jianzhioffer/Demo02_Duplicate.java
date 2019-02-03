package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/1/4.
 */
public class Demo02_Duplicate {


    //1.利用数组做一个hash，时间复杂度o(n),空间复杂度o(n)
    public static int getRepeatedNum1(int[] a) {
        if (a == null || a.length == 0)
            return -1;
        //检查数据条件
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] < 0 || a[i] > a.length - 1)
                return -1;
        }

        int[] hashtable = new int[a.length];
        for (int num : a) {
            if (hashtable[num] >= 1) {
                return num;
            } else {
                hashtable[num] = 1;
            }
        }
        return -1;
    }


    //2. 根据数字特点排序，会修改原始数据，时间复杂度o(n),空间复杂度o(1)
    public static int getRepeatedNum2(int[] a) {
        if (a == null || a.length == 0)
            return -1;
        //检查数据条件
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] < 0 || a[i] > a.length - 1)
                return -1;
        }

        int length = a.length;

        for (int j = 0; j < length-1; j++) {
            while (a[j] != j) {
                if (a[j] == a[a[j]])
                    return a[j];
                else {
                    int tmp = a[j];
                    a[j] = a[a[j]];
                    a[a[j]] = tmp;
                }
            }
        }
        return  -1;
    }
}
