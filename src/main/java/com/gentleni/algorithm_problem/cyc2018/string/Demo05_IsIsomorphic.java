package com.gentleni.algorithm_problem.cyc2018.string;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo05_IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i ;
            preIndexOfT[tc] = i ;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper","title"));
    }
}
