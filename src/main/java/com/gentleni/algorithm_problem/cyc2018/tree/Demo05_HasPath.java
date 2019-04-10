package com.gentleni.algorithm_problem.cyc2018.tree;

/**
 * Created by GentleNi
 * Date 2019/3/18.
 */
public class Demo05_HasPath {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && sum == root.val)
            return true;
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}