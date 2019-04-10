package com.gentleni.algorithm_problem.cyc2018.tree;


/**
 * Created by GentleNi
 * Date 2019/3/18.
 */
public class Demo03_MirrorTree {
    public void mirror(TreeNode root) {
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
