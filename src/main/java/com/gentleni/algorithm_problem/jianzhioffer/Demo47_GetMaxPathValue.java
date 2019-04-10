package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/3/4.
 */
public class Demo47_GetMaxPathValue {
    public  static int getMaxPathValue(int[][] values) {
        if (values == null) return 0;

        int rows = values.length;
        if (rows <= 0) return 0;
        int cols = values[0].length;
        if (cols <= 0) return 0;

        int[][] maxValues = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int fromLeft = 0;
                int fromUp = 0;
                if (i > 0)
                    fromUp = maxValues[i-1][j];
                if (j > 0)
                    fromLeft = maxValues[i][j-1];
                maxValues[i][j] = Math.max(fromLeft,fromUp) + values[i][j];
            }
        }
        return maxValues[rows-1][cols-1];
    }
}
