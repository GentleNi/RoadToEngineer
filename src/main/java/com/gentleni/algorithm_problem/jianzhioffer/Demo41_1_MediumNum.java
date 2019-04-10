package com.gentleni.algorithm_problem.jianzhioffer;

import java.util.PriorityQueue;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 * 左侧是小的部分，大根堆
 * 右侧是大的部分，小根堆
 * 保证右侧 》= 左侧
 */
public class Demo41_1_MediumNum {
    /* 大顶堆，存储左半边元素 */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /* 当前数据流读入的元素个数 */
    private int N = 0;

    public void Insert(Integer val) {
        if (N % 2 == 0) {//此时左右堆个数相等，向右侧添加
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }
    public Double GetMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();
    }
}
