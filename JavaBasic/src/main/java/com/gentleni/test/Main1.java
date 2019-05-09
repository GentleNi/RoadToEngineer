package com.gentleni.test;
import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] cnt = new int[10];
        for (int i = 0; i <= 9;i++) {
            cnt[i] = in.nextInt();
        }

        int numsOfA = in.nextInt();
        int numsOfB = in.nextInt();

        if (numsOfA <= cnt[0] || numsOfB <= cnt[0]) {
            System.out.println(0);
            return;
        }

        String sa = "";
        String sb = "";
        int turn = 0;

        for (int i = 0; i < cnt.length;i++) {
            while (cnt[i] > 0) {
                if (numsOfA <=0 && numsOfB <=0)
                    break;
                if (numsOfA > 0  && cnt[i] > 0 && turn == 0) {
                    sa += i;
                    cnt[i]--;
                    numsOfA--;
                    if (numsOfB > 0) {
                        turn = 1;
                    }
                } else if (numsOfB > 0 && cnt[i] > 0 && turn == 1) {
                    sb += i;
                    cnt[i]--;
                    numsOfB--;
                    if (numsOfA > 0) {
                        turn = 0;
                    }
                }
            }
        }

        BigInteger a = new BigInteger(sa);
        BigInteger b = new BigInteger(sb);

        System.out.println(a.multiply(b));

    }

}