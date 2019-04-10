package com.gentleni.algorithm_problem.cyc2018.tree;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by GentleNi
 * Date 2019/3/18.
 */
public class Demo06_HasPathNum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    private int pathSumStartWithRoot(TreeNode root, int sum) {
      if (root == null)
          return 0;
      int ret = 0;
      if (root.val == sum)
          ret++;
      ret += pathSumStartWithRoot(root.left,sum - root.val) + pathSumStartWithRoot(root.right,sum - root.val);
      return ret;
    }
}
