package com.gentleni.test;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static Map<Integer,Integer> map;
    static int rewardPig;
    static {
        map = new HashMap<>();
        rewardPig = 0;
    }


/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String calculate(int m, int k) {
        int num = getNum(m-1,k);
        return String.valueOf(num) + "," + String.valueOf(2018 + getYear(m))+ "," +String.valueOf(rewardPig);
    }

    public static int getNum(int n,int k) {
        int num = 0;
        if (n == 1) return 2;
        if (n == 2) return 3;
        if (n == 3) return 4;

        int[] arr = new int[n+1];
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 4;
        map.put(2,0);
        map.put(3,1);
        map.put(4,2);
        for (int i = 3; i <= n;i++) {
            arr[i] = arr[i-2] + arr[i-3];
            map.put(reverse(arr[i]),i);
        }

        num = arr[n];
        //查找反转数字第K大
        for (int i = 0; i <= n;i++) {
            arr[i] = reverse(arr[i]);
        }
        Arrays.sort(arr);
        rewardPig = map.get(arr[n-k-1]);
        return num;
    }

   private static int getYear(int m) {
        int year3 = 1;
        int year2 = 0;
        int year1 = 1;
        int sum = 2;
        int year = 1;
        while (sum < m) {
            int tmp = year3;
            year3 += year2;
            year2 = year1;
            year1 = tmp;
            sum = year1 + year2 + year3;
            year++;
        }
        return year;
   }

    private static int reverse(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        reverse(chars,0,chars.length-1);
        return Integer.parseInt(new String(chars));
    }

    private static void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private static void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);
        System.out.println(calculate(m, k));

    }
}