package com.gentleni.algorithm.leetcode_cn.array.window;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GentleNi
 * Date 2019/5/9.
 */
public class Demo438_FindAllAnagramsInString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {

            //如果右边界的字符已经在哈希表中了，说明该字符在p中有出现，则cnt自减1，
            // 然后哈希表中该字符个数自减1，右边界自加1
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //如果此时cnt减为0了，说明p中的字符都匹配上了，那么将此时左边界加入结果res中
            if (count == 0) list.add(left);
            //如果此时right和left的差为p的长度，说明此时应该去掉最左边的一个字符，
            // 我们看如果该字符在哈希表中的个数大于等于0，说明该字符是p中的字符，
            // 为啥呢，因为上面我们有让每个字符自减1，如果不是p中的字符，那么在哈希表中个数应该为0，
            // 自减1后就为-1，所以这样就知道该字符是否属于p，如果我们去掉了属于p的一个字符，cnt自增1
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("abcbacb", "abc");
        for(int i : anagrams) {
            System.out.println(i);
        }
    }
}
