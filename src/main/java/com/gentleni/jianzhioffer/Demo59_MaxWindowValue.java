package com.gentleni.jianzhioffer;

import java.util.*;

/**
 * Created by GentleNi
 * Date 2019/2/23.
 */
public class Demo59_MaxWindowValue {
    //分析
//    public ArrayList<Integer> maxInWindows(int[] num, int size) {
//        ArrayList<Integer> windows = new ArrayList<>();
//        if (num == null || num.length == 0 || size <= 0 || size > num.length)
//            return windows;
//        Queue<Integer> maxWindowQueue = new LinkedList<>();
//        int currentMax = num[0];
//        for (int i = 0; i < size; i++) {
//            maxWindowQueue.add(num[i]);
//            if (num[i] > currentMax)
//                currentMax = num[i];
//        }
//
//
//    }


    //第二种使用大顶堆实现，priorityQueue
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
