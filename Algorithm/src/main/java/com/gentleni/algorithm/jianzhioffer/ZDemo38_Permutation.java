package com.gentleni.algorithm.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by GentleNi
 * Date 2019/2/19.
 */
public class ZDemo38_Permutation {
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            System.out.println(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) /* 保证不重复 */
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        ZDemo38_Permutation demo = new ZDemo38_Permutation();
        demo.Permutation("aab");
    }
}
