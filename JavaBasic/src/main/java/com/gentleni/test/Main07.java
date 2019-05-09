package com.gentleni.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by GentleNi
 * Date 2019/4/8.
 */
public class Main07 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        if (n == 1) {
            System.out.println();
            System.out.println(1);
            return;
        }
        System.out.println(LastRemaining_Solution(n,m)+1);
    }

    public static int LastRemaining_Solution(int n, int m) {
        if (m == 0 || n == 0) {
            return -1;
        }
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = -1;
        while (data.size() > 1) {
            index = (index + m) % data.size();
            Integer remove = data.remove(index);
            if (data.size() > 1) {
                System.out.print(remove+1 + " ");
            } else {
                System.out.print(remove+1);
            }
            index--;
        }
        System.out.println();
        return data.get(0);
    }
}
