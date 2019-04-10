package com.gentleni.algorithm_problem.jianzhioffer;


import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/1/31.
 */
public class Demo09_QueueByStack {
    private static Stack<Integer> in = new Stack<>();
    private static Stack<Integer> out = new Stack<>();

    public static void push(int a) {
        in.push(a);
    }

    public static int pop() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.pop();
    }


}
