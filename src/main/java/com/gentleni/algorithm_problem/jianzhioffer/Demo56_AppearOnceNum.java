package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 */
public class Demo56_AppearOnceNum {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null ||array.length<2)
            return ;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp^=array[i];
        }
        //找到这两个不同的数字的二进制第一个位不一样的,从后往前
        int index =  findFirstBitIs(temp);

        for(int i=0;i<array.length;i++){
            if (isBit(array[i],index)) {
                num1[0] ^= array[i];
            } else {
                num2[0]^=array[i];
            }
        }
    }

    private int findFirstBitIs(int num) {
        int index = 0;
        while ((((num & 1) == 0) && index < 8*4)) {//整形32位
            num = num >> 1;
            ++ index;
        }
        return index;
    }

    //查看该数字从后往前index位是不是1
    private boolean isBit(int num,int index) {
        int bitNum = num >> index;
        return (bitNum & 1) == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Demo56_AppearOnceNum().findFirstBitIs(8));
    }
}
