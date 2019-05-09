package com.gentleni.algorithm.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/11.
 */
public class Demo13_RobotMovingRange {

    public int movingCount(int threadhold, int rows, int cols) {
        //检查输入有效性
        if (threadhold <= 0 || rows <= 0 || cols <= 0)
            return 0;
        //创建标记矩阵
        boolean[][] visited = new boolean[rows][cols];
        return count(threadhold,0,0,rows,cols,visited);
    }

    private int count(int threadhold, int row, int col, int rows, int cols, boolean[][] visited) {
        int count = 0;
        if (checkValid(threadhold, rows, cols, row, col, visited)) {
            visited[row][col] = true;
            count = 1 + count(threadhold, row + 1, col, rows, cols, visited) +
                    count(threadhold, row - 1, col, rows, cols, visited) +
                    count(threadhold, row, col + 1, rows, cols, visited) +
                    count(threadhold, row, col - 1, rows, cols, visited);
            //因为不是查找一个路径，而是覆盖所有格子，所以不用重置visited
        }
        return count;
    }

    private boolean checkValid(int threadhold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col] && getDigitSum(row) + getDigitSum(col) <= threadhold)
            return true;
        return false;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Demo13_RobotMovingRange range = new Demo13_RobotMovingRange();
        int count = range.movingCount(2,2,2);
        System.out.println(count);
    }
}
