package com.gentleni.algorithm_problem.jianzhioffer;

import java.lang.invoke.LambdaConversionException;

/**
 * Created by GentleNi
 * Date 2019/2/17.
 */
public class Demo33_VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0)
            return false;
        return verify(sequence,0, sequence.length - 1);

    }


    private boolean verify(int[] sequence, int first, int last) {
        //递归退出条件
        if (last - first <= 1)
            return true;
        //最后一个数是根节点
        int rootVal = sequence[last];
        int cutIndex = first;
        //所有小于根节点的为左子树
        while (cutIndex < last && sequence[cutIndex] < rootVal)
            cutIndex++;
        //右子树应当都比根节点大
        for (int i = cutIndex;i < last; i++) {
            if (sequence[i] < rootVal)
                return false;
        }
        //递归左右子树
        return verify(sequence,first,cutIndex-1) && verify(sequence,cutIndex,last);
    }

}
