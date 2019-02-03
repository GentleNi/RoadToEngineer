package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/1/31.
 */
public class Demo10_1_JumpFloor {

    public int JumpFloor(int n) {
        if (n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 1;
        for (int i = 3; i <= n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Demo10_1_JumpFloor demo = new Demo10_1_JumpFloor();
        System.out.println(demo.JumpFloor(3));
    }
}
