package com.gentleni.test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by GentleNi
 * Date 2019/4/8.
 */
public class XieCheng3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i ++) {
            str[i] = in.next();
        }

        String[] result = new String[n];


        HashMap<String,String> strMap = new HashMap<>();

        for (int i = 0; i < n; i ++) {
            result[i] = "";
            if (str[i].charAt(str[i].length()-1) == '/') {
                str[i] = str[i].substring(1,str[i].length()-1);

            } else {
                str[i] = str[i].substring(1,str[i].length());
            }
            String[] subPath = str[i].split("/");

            //有相同的路径
            if (strMap.containsKey(str[i])) {
                String res = strMap.get(str[i]);
                char[] chars = res.toCharArray();
                for (int k = 1; k < chars.length-1;k++) {
                    chars[k]  = (char) (chars[k] + 1);
                }
                res = String.valueOf(chars);
                result[i] = res;
                strMap.put(str[i],res);
            } else {
                for (int j = 0; j < subPath.length; j++) {
                    result[i] += "1";
                }
                strMap.put(str[i],result[i]);
            }

        }

        for (int i = 0; i < n;i++) {
            if (i != n-1)
                System.out.print(result[i] + " ");
            else {
                System.out.print(result[i]);
            }
        }
    }

}
