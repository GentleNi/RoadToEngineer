package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 */
public class Demo41_2_2_FirstAbsenceOnce {
    int[] hashtable=new int[256];
    StringBuffer s=new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch) {
        s.append(ch);
        hashtable[ch]++;
    }

    public char FirstAppearingOnce(){
        char[] str=s.toString().toCharArray();
        for (char c : str) {
            if (hashtable[c] == 1){
                return c;
            }
        }
        return '#';
    }
}
