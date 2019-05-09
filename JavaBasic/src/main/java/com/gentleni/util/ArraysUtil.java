package com.gentleni.util;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by GentleNi
 * Date 2019/3/1.
 */
public class ArraysUtil {

    private static final Random RANDOM = new Random();
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int[] initArrayAesc(int start, int end) {
        int len = end - start + 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = start + i;
        }
        return arr;
    }

    public static int[] createArrayRandom(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = RANDOM.nextInt(100);
        }
        return arr;
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
}
