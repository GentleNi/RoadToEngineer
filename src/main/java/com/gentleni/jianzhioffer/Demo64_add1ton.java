package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/23.
 */
public class Demo64_add1ton {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(5));
    }

    //这也太牛逼了吧
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

}
