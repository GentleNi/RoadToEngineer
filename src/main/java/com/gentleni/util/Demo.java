package com.gentleni.util;

import java.util.Scanner;

/**
 * Created by GentleNi
 * Date 2019/3/9.
 */
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        if (m >= n)
            System.out.println(1);
        else {
            int k = n / m;
            System.out.println(k + 1);
        }
    }
}
