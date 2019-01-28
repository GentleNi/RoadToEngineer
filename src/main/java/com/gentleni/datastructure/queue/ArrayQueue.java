package com.gentleni.datastructure.queue;

import javax.print.attribute.standard.NumberUp;

/**
 * Created by GentleNi
 * Date 2019/1/16.
 */
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == n)
            return false;
        items[tail++] = item;
        return true;
    }

    public String dequeue(String item) {
        if (head == tail) return null;
        String ret = items[head++];
        return ret;
    }
}
