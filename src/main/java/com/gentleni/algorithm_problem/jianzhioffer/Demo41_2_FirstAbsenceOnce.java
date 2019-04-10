package com.gentleni.algorithm_problem.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 */
public class Demo41_2_FirstAbsenceOnce {
    //两种思路，第一种利用队列
    private int[] cnts = new int[256];//存放字符出现次数，hash表
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)//如果刚刚插入的不是第一次出现，则出队
            queue.poll();
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }

    public static void main(String[] args) {
        Demo41_2_FirstAbsenceOnce demo = new Demo41_2_FirstAbsenceOnce();
        StringBuilder sb = new StringBuilder("google");
        for (char c : sb.toString().toCharArray()) {
            demo.Insert(c);
        }
        System.out.println(demo.FirstAppearingOnce());
    }
}
