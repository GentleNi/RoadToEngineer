package com.gentleni.algorithm.cyc2018.stackandqueue;

import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/3/20.
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c1 = stack.pop();
                boolean b1 = c == ')' && c1 != '(';
                boolean b2 = c == ']' && c1 != '[';
                boolean b3 = c == '}' && c1 != '{';
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
