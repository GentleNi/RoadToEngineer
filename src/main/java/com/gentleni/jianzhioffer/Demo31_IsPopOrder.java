package com.gentleni.jianzhioffer;

import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/2/15.
 */
public class Demo31_IsPopOrder {
    public boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        if (pushSequence == null || popSequence == null || pushSequence.length <= 0 || popSequence.length <= 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushSequence.length;i++){
            s.push(pushSequence[i]);
            while (!s.empty() && s.peek() == popSequence[i]) {
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }
}
