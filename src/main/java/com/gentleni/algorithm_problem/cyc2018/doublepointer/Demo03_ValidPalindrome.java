package com.gentleni.algorithm_problem.cyc2018.doublepointer;

/**
 * Created by GentleNi
 * Date 2019/3/21.
 */
public class Demo03_ValidPalindrome {

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i++ < j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
            }
        }
        return true;
    }


    private boolean isPalindrome(String s,int i , int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Demo03_ValidPalindrome().validPalindrome("abca"));
    }
}
