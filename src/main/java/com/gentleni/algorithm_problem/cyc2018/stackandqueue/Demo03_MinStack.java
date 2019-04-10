package com.gentleni.algorithm_problem.cyc2018.stackandqueue;

import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/3/20.
 */
public class Demo03_MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    public Demo03_MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int v) {
        dataStack.push(v);
        min = Math.min(v,min);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }
    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
