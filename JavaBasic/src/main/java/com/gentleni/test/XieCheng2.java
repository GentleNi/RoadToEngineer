package com.gentleni.test;

/**
 * Created by GentleNi
 * Date 2019/4/8.
 */
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by GentleNi
 * Date 2019/4/8.
 */
public class XieCheng2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int k = in.nextInt();
        if (k == 0) {
            System.out.println(s);
            return;
        }
        if (s.length() == 0) {
            System.out.println("[]");
            return;
        }
        s = s.substring(1,s.length()-1);
        String[] str = s.split(",");
        int[] arr = new int[str.length];
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        //k大于length的情况
        if (k > str.length) {
            String s1 = Arrays.toString(arr);
            s1 = s1.replaceAll(" ","");
            System.out.println(s1);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if ((i+1) % k == 0 && (i+1) <arr.length) {
                reverse(arr,start,i);
                start = i+1;
            }
        }

        String s1 = Arrays.toString(arr);
        s1 = s1.replaceAll(" ","");
        System.out.println(s1);
    }

    private static void reverse(int[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private static void swap(int[] c, int i, int j) {
        int t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
