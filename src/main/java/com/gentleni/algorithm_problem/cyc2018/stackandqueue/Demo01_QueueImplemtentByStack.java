package com.gentleni.algorithm_problem.cyc2018.stackandqueue;

import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/3/20.
 */
public class Demo01_QueueImplemtentByStack {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        in2out();
        return out.pop();
    }

    public int peek() {
        in2out();
        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

}
