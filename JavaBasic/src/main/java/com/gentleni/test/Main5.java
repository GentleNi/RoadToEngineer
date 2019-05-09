package com.gentleni.test;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by GentleNi
 * Date 2019/4/8.
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int m = scan.nextInt();

        if (n <= m) {
            System.out.println(k);
            return;
        }
        int count = n * k;
        int time = count / m + ((count % m) == 0 ? 0 : 1);
        System.out.println(time);

    }


}
