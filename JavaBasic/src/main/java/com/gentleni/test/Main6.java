package com.gentleni.test;

import java.util.Scanner;

/**
 * Created by GentleNi
 * Date 2019/4/11.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t;i++) {
            int a = scan.nextInt();
            System.out.println(jump(a));
        }
    }

    private static int jump(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 1) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
            count++;
        }
        return count;
    }
}
