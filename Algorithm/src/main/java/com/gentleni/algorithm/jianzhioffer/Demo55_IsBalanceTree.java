package com.gentleni.algorithm.jianzhioffer;



/**
 * Created by GentleNi
 * Date 2019/3/7.
 */
public class Demo55_IsBalanceTree {

    boolean isBalanced = true;

    // Method 1
    public boolean isBalanceTree(TreeNode root) {
       treeDepth(root);
       return isBalanced;
    }

    public int  treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1)
            isBalanced = false;
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
