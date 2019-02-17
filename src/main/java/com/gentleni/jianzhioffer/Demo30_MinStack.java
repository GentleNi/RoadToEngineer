package com.gentleni.jianzhioffer;


import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/2/15.
 */
public class Demo30_MinStack {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int data) {
        if (minStack.isEmpty()) {
            minStack.push(data);
        } else {
            if (data <= minStack.peek()) {
                minStack.push(data);
            }
        }
        dataStack.push(data);
    }

    void pop() {
        if(dataStack.peek()==minStack.peek())
            minStack.pop();
        dataStack.pop();

    }

    int top() {
        return dataStack.peek();
    }

    int min() {
        return minStack.peek();
    }
}
