package com.gentleni.algorithm.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by GentleNi
 * Date 2019/2/25.
 */
public class Demo62_LastRemaining {
    public static int LastRemaining_Solution(int n, int m) {
        if (m == 0 || n == 0) {
            return -1;
        }
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = -1;
        while (data.size() > 1) {
            index = (index + m) % data.size();
            data.remove(index);
            index--;
        }
        return data.get(0);
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5,3));
    }
}
