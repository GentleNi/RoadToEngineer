package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/12.
 * 具体的条件是：  非空判断
                               1，先判断符号位，当前索引后移，检查是否只有符号
                               2，符号位后是不是纯数字，跳过纯数字，对第一个非数字进行判断
                               A，数字后是小数点“.”，索引后移，判断小数点后面的数
                                       -------------此时情况太多----------------------------------------------
                                                  a ，小数点后是指数字母E/e
                                                  b，小数点后是其他非数字的字母
                                                 c，小数点后是数字，跳过数字，对数字后面进行判断
                                                           c1，数字后是E/e，
                                                           c2,数字后是其他
                               B，数字后是指数字母E/e
                              C，数字后是其他字符
 至此情况完毕，其中每次索引后移后先判断是否到达末尾。
 ---------------------
 */
public class Demo21_IsNumeric {
    public boolean isNumeric(char[] str) {
    	/*
    	 * 几个关键点：
              1.基本边界。
              2.检测是否有符号位
              3.检测除符号位外的第一个有效位，有效位只能是数字或者小数点.
              4.检测是否有E或者e，且不能重复出现
              5.小数点不能重复出现
              6.数字的合法性，不能是其他字母如‘a’等
    	 */
        if(str==null||str.length==0) return false;
        int index=0;
        if(str[index]=='+'||str[index]=='-')
            index++;
        if(index>=str.length) return false;//只有符号，肯定不是数
        while(index<str.length){
            if(!isNum(str[index]))
                break;
            index++;
        }
        //符号后面的数字都跳过，此时Index处不是数字
        if(index<str.length){
            if(str[index]=='.'){//1,小数点
                index++;
                if(index>=str.length) return true;//a,只有小数点的数 "600."(测试用例告诉我们算true)
                if(str[index]=='e'||str[index]=='E')
                    return false;//b,小数点后还有字母Ee
                if(!isNum(str[index]))
                    return false;//c,小数点后是其他字母
                //否则就是数字，跳过数字
                while(index<str.length){
                    if(!isNum(str[index]))
                        break;
                    index++;
                }
                if(index>=str.length) return true;//纯数字
                else if(str[index]=='e'||str[index]=='E'){
                    return isExpon(str, index);
                }else{
                    return false;
                }
            }else if(str[index]=='e'||str[index]=='E'){//2,指数
                return isExpon(str, index);
            }else{//其他字母
                return false;
            }
        }
        return true;
    }

    //判断是不是数字
    boolean isNum(char ch){
        if(ch>='0'&&ch<='9')
            return true;
        return false;
    }

    //判断当前位置开始是不是指数形式的数字
    boolean isExpon(char[] str,int beginIndex){
        if(str[beginIndex]!='e'&&str[beginIndex]!='E') return false;
        beginIndex++;
        if(beginIndex<str.length&&(str[beginIndex]=='+'||str[beginIndex]=='-'))
            beginIndex++;//e/E的后面有符号
        if(beginIndex>=str.length) return false;//后面必须要数字
        while(beginIndex<str.length){
            if(!isNum(str[beginIndex]))
                break;
            beginIndex++;
        }
        return beginIndex==str.length?true:false;
    }

}
