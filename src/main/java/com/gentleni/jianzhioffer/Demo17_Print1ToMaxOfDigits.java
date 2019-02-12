package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/11.
 */
public class Demo17_Print1ToMaxOfDigits {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    //递归实现遍历(全排列)
    private void print1ToMaxOfNDigits(char[] number, int digit) {
        //递归出口
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        //从左到右找到第一个非零数字
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }

    public static void main(String[] args) {
        Demo17_Print1ToMaxOfDigits demo = new Demo17_Print1ToMaxOfDigits();
        demo.print1ToMaxOfNDigits(3);
    }
}
