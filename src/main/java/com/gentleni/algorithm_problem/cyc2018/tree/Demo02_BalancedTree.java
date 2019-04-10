package com.gentleni.algorithm_problem.cyc2018.tree;

/**
 * Created by GentleNi
 * Date 2019/3/18.
 */
public class Demo02_BalancedTree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1)
            isBalanced = false;
        return 1 + Math.max(l,r);
    }
}