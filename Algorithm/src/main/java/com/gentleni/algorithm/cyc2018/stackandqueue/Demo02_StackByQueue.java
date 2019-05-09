package com.gentleni.algorithm.cyc2018.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GentleNi
 * Date 2019/3/27.
 */
public class Demo02_StackByQueue {
    private Queue<Integer> queue;

    public Demo02_StackByQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.add(queue.poll());
        }

    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
