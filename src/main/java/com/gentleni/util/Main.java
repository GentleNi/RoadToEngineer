package com.gentleni.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by GentleNi
 * Date 2019/3/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();//小Q最终得分
        Set<Integer> set = new HashSet<>();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }

        int startIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = i ; j < m;j++) {
                if (set.size() == n) {
                    min = Math.min(min,j - i);
                    System.out.println(min);
                    //return;
                }
                set.add(a[j]);
            }

        }
        System.out.println(-1);
    }

}
