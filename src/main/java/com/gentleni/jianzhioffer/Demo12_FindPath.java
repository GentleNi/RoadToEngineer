package com.gentleni.jianzhioffer;

import java.util.Calendar;

/**
 * Created by GentleNi
 * Date 2019/2/2.
 */
public class Demo12_FindPath {

    public static void main(String[] args) {
        Demo12_FindPath main = new Demo12_FindPath();
        //main.hasPath();
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length == 1 && str.length == 1 && matrix[0] == str[0])
            return true;
        char[][] mat = new char[rows][cols];
        //Build Matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = matrix[i * cols + j];

            }
        }

        //从每个点开始一次
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                boolean res = dfs(mat,i,j,0,str,visited);
                if (res)
                    return true;
            }
        }

        return false;
    }

    public static boolean dfs(char[][] mat, int i, int j, int id, char[] str, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= mat.length || j >=mat[0].length || id > str.length)
            return false;
        if (id == str.length -1)
            return true;
        if (!visited[i][j] && mat[i][j] == str[id]) {
            visited[i][j] = true;
            boolean res = dfs(mat, i, j+1,id+1, str,visited)||
                    dfs(mat,i,j-1,id+1,str,visited)||
                    dfs(mat,i-1,j,id+1,str,visited)||
                    dfs(mat,i+1,j,id+1,str,visited);
            visited[i][j] = false;
            return res;
        }
        return false;
    }
}