package com.gentleni.algorithm.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 */
public class Demo58_ReverseSentence {

    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0,j = 0;
        //单词交换
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars,i,j-1);
                i = j+1;
            }
            j++;
        }
        //整体交换
        reverse(chars,0,n-1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

}
