package com.gentleni.algorithm.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/3/6.
 */
public class Demo50_FirstNotRepeatingChar {

    public static int FirstNotRepeatingChar(String str) {
        int[] cnt = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - '0';
            cnt[index] ++;
        }

        for (int i = 0; i < str.length(); i++)
            if (cnt[str.charAt(i) - '0'] == 1)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("aaabbbcdfdfd"));
        System.out.println('c');
        System.out.println('c' - '0');
    }
}
