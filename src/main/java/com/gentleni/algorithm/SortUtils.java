package com.gentleni.algorithm;

import java.util.Random;

/**
 * Created by GentleNi
 * Date 2018/11/14.
 */
public class SortUtils {

    /**
     * 随机生成一个指定容量的数组
     * @param cap
     * @return
     */
    public static int[] createRandomArray(int cap) {
        int[] a = new int[cap];
        Random random = new Random();
        for (int i = 0; i < cap; i++) {
            a[i] = random.nextInt(100);
        }
        return a;
    }


    /**
     * 打印数组
     * @param a
     */
    public static void printArray(int[] a) {
        System.out.print("The Array is: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    /**
     * 判断数组是不是已经排序好
     * @param a
     * @return
     */
    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i-1])
                return false;
        }
        return true;
    }


    /**
     * 交换数组元素
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[] a,int i,int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] randomArray = createRandomArray(10);
        printArray(randomArray);
        swap(randomArray,1,2);
        printArray(randomArray);
    }

}
