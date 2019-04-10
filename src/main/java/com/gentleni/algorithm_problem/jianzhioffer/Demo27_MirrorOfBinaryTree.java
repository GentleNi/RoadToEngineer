package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/15.
 */
public class Demo27_MirrorOfBinaryTree {

    public void mirror(TreeNode root) {
        if (root == null)
            return;
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }

}
