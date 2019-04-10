package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 */
public class Demo55_TreeDepth {

    public int  treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right =root5;
        root3.left = root6;

        new Demo55_TreeDepth().treeDepth(root);
    }
}
