package com.gentleni.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by GentleNi
 * Date 2019/2/25.
 */
public class Demo62_LastRemaining {
    int LastRemaining_Solution(int n, int m) {
        if (m == 0 || n == 0) {
            return -1;
        }
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = -1;
        while (data.size() > 1) {
            index = (index + m) % n;
            data.remove(index);
            index--;
        }
        return data.get(0);
    }
}
