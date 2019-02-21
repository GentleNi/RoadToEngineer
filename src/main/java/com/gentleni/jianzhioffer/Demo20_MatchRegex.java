package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/12.
 */

/**
 * 解题思路
 当模式中的第二个字符不是“*”时：
 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

 而当模式中的第二个字符是“*”时：
 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
 1、模式后移2字符，相当于x*被忽略；
 2、字符串后移1字符，模式后移2字符；
 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位。
 */
public class Demo20_MatchRegex {
    public boolean match(char[] str, char[] pattern)    {
        int sindex = 0, pindex = 0;
        return matchCore(str, sindex, pindex, pattern);
    }

    public boolean matchCore(char[] str, int sindex, int pindex, char[] pattern){
        // 同时结束
        if(sindex == str.length && pindex == pattern.length)
            return true;
        //pattern先到尾，匹配失败
        if (sindex != str.length && pindex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if(pindex+1 < pattern.length && pattern[pindex+1] == '*'){
            if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.') ){
                return matchCore(str, sindex, pindex+2, pattern) ||
                        matchCore(str, sindex+1, pindex+2, pattern ) ||
                        matchCore(str, sindex+1, pindex, pattern);
            }else{
                return matchCore(str, sindex, pindex+2, pattern);
            }
        }
        //如果下一位不是‘*’，则只要匹配'.'，匹配成功后，同时移动一个字符
        if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex+1, pindex+1, pattern);
        return false;
    }
}
