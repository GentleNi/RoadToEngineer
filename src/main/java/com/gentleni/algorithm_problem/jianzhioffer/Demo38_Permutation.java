package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/3/22.
 */
public class Demo38_Permutation {
    public static void Permutation(char[] s, int from, int to) {
        if(to<=1)
            return;
        if(from == to){
            System.out.println(s);
        }
        else{
            for(int i=from;i<=to;i++) {
                if(isNeedSwap(s,from,i)) {
                    swap(s,i,from);
                    Permutation(s,from+1,to);
                    swap(s,from,i);
                }
            }
        }
    }

    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    private static boolean isNeedSwap(char[] s, int from, int k) {
        boolean flag = true;
        for (int i = from; i < k; i ++) {
            if (s[i] == s[k]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Permutation("aaabc".toCharArray(),0,4);
    }
}
