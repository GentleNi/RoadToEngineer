package com.gentleni.exception;

/**
 * Created by GentleNi
 * Date 2017/11/9.
 */
public class ZeroTest {
    public static  void  main(String[] args) {
        try{
            int i = 100 / 0;
            System.out.print(i);
        }catch(Exception e){
            System.out.println(1);
            throw new  RuntimeException();
        }finally{
            System.out.println(2);
        }
        System.out.print(3);
    }
}
