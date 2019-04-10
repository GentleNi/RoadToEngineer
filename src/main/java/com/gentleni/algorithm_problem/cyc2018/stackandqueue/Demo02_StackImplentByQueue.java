package com.gentleni.algorithm_problem.cyc2018.stackandqueue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GentleNi
 * Date 2019/3/20.
 */
public class Demo02_StackImplentByQueue {
    private Queue<Integer> queue1  = new LinkedList<>();
    private Queue<Integer> queue2  = new LinkedList<>();

    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    public int pop() throws NoElementException {
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size-1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue2.poll();
        } else if (!queue2.isEmpty()) {
            int size = queue1.size();
            for(int i=0;i<size-1;i++)
                queue2.offer(queue1.poll());
            return queue1.poll();
        } else {
           throw new NoElementException();
        }
    }



}

class NoElementException extends Exception {

}