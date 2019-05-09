package com.gentleni.datastructure.queue;

/**
 * Created by GentleNi
 * Date 2019/1/16.
 */
public class ResingArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public ResingArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        if(tail == n) {
            if (head == 0) {//真满了
                return false;
            } else {//不是真的满，可以搬运
                for (int i = head; i < tail; i++) {
                    items[i-head] = items[i];
                }
                tail-=head;
                head = 0;
            }
        }

        items[tail++] = item;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) return null;
        // 为了让其他语言的同学看的更加明确，把--操作放到单独一行来写了
        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
