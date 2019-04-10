package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 */
public class ZDemo43_NumberOf1Between1AndN_Solution {

    //1.暴力法
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        StringBuffer s=new StringBuffer();
        for(int i=1;i<n+1;i++){
            s.append(i);
        }
        String str=s.toString();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')
                count++;
        }
        return count;
    }


}
