package com.gentleni.algorithm_problem.cyc2018.bit;

/**
 * Created by GentleNi
 * Date 2019/3/27.
 */
public class Demo03_TwoSingleNum {
    public static void getTheTwo(int[] arr,int num1,int num2){
        if(arr == null || arr.length <= 1)
            return;
        int len = arr.length;
        int tmp = arr[0];
        for(int i = 1; i < len; i++){
            tmp ^= arr[i];
        }
        int index = findFirstOne(tmp);
        for(int i = 0; i < len; i++){
            if(isOne(arr[i],index)){
                num1 ^= arr[i];
            }else{
                num2 ^= arr[i];
            }
        }
    }
    public static int findFirstOne(int n){
        int i = 0;
        while((n & 1) == 0){
            i++;
            n = n >> 1;
        }
        return i;
    }
    public static boolean isOne(int num,int index){
        if(((num >> index) & 1) == 1)
            return true;
        return false;
    }
}
