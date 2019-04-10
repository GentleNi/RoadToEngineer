package com.gentleni.algorithm_problem.jianzhioffer;

import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/2/15.
 */
public class Demo31_IsPopOrder {

    //push : 12345
    //pop  : 45321
    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
