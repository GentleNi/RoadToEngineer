package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/3/5.
 */
public class Demo48_FindLongestSubstringLength {

    public static int findLongestSubstringLength(String string) {
        if (string == null || string.equals("")) return 0;
        int maxLength = 0;
        int curLength = 0;
        int[] positions = new int[26];
        for (int i = 0; i < positions.length; i++)
            positions[i] = -1;
        for (int i = 0; i < string.length(); i++) {
            int currChar = string.charAt(i) - 'a';
            int prePos = positions[currChar];
            //当前字符和上次出现的字符之间的距离
            int distance = i - prePos;
            //当前字符第一次出现，或者前一个非重复子字符串中没有包含当前字符
            if(prePos < 0 || distance  > curLength) {
                curLength++;
            } else {
                //更新最长非重复子字符串的长度
                if (curLength > maxLength)
                    maxLength = curLength;
                curLength = distance;
            }
            //更新字符出现位置
            positions[currChar] = i;
        }
        if (curLength > maxLength)
            maxLength = curLength;
        return maxLength;
    }
}
