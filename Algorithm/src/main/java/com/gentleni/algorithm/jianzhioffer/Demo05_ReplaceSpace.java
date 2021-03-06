package com.gentleni.algorithm.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
public class Demo05_ReplaceSpace {

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("A B C")));
    }

    public static String replaceSpace(StringBuffer str) {
        int p1 = str.length()-1;
        for (int i = 0;i < p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--,'%');
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
            } else {
                str.setCharAt(p2--,c);
            }
        }
        return str.toString();
    }
}
