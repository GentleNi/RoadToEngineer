package com.gentleni.test;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Created by GentleNi
 * Date 2019/4/9.
3 18
4 4 4 2 2 2
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        int n = Integer.parseInt(str1[0]);
        int w = Integer.parseInt(str1[1]);
        int len = 2 * n;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(str2[i]);
        }

        int minManCup = Integer.MAX_VALUE;
        int minWomanCup = Integer.MAX_VALUE;
        double base = Double.MAX_VALUE;
        //找到最小容量的杯子
        for (int i = 0; i < n;i++) {
            if (arr[i] < minManCup)
                minManCup = arr[i];
        }

        for (int i = n; i < len;i++) {
            if (arr[i] < minWomanCup)
                minWomanCup = arr[i];
        }
        //找基准
        if ((double) minManCup / 2 < (double) minWomanCup) {
            base = (double) minManCup / 2;
        } else {
            base = minWomanCup;
        }

        double count = (base * n + base * 2 * n);
        if (count <= w) {
            System.out.printf("%.6f",count);
        } else {
            double dw = Double.parseDouble(String.valueOf(w));
            System.out.printf("%.6f",dw);
        }

    }
}
