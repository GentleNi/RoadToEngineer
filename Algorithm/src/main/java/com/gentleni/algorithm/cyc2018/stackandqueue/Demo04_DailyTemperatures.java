package com.gentleni.algorithm.cyc2018.stackandqueue;


import java.util.Stack;
import java.util.zip.CRC32;

/**
 * Created by GentleNi
 * Date 2019/3/20.
 */
public class Demo04_DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int dist[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int currIndex = 0; currIndex < n; currIndex++) {
            while (!stack.isEmpty() && temperatures[currIndex] > temperatures[stack.peek()]) {
                int preIndex = stack.pop() ;
                dist[preIndex] = currIndex - preIndex;
            }
            stack.add(currIndex);
        }
        return dist;
    }
}
