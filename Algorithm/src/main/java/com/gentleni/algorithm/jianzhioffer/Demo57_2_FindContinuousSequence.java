package com.gentleni.algorithm.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by GentleNi
 * Date 2019/3/7.
 */
public class Demo57_2_FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if(sum == 0)
            return ret;
        int start = 1, end = 2;
        int currSum = 3;
        while (end < sum) {
            if (currSum > sum) {
                start++;
                currSum-=start;
            } else if (currSum < sum) {
                end++;
                currSum+=end;
            } else {//找到一个数对
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end;i++) {
                    list.add(i);
                }
                ret.add(list);
                start++;
                currSum-=start;
                end++;
                currSum+=end;
            }
        }
        return ret;
    }
}
