package com.gentleni.algorithm_problem.cyc2018.dynamicprogram;

/**
 * Created by GentleNi
 * Date 2019/3/21.
 */
public class Demo_MinPathSum {
    public int getPathLen(int [][]matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int [][]dp=new int[row][col];
        dp[0][0]=matrix[0][0];
        for(int i=1;i<row;i++){//找到第一列的dp值
            dp[i][0]=dp[i-1][0]+matrix[i][0];
        }
        for(int j=1;j<col;j++){//找到第一行的dp值
            dp[0][j]=dp[0][j-1]+matrix[0][j];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];//当前dp值为 从左边、上边两个位置取一个最小值，加上本身
            }
        }
        return dp[row-1][col-1];
    }

}
