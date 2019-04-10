package com.gentleni.algorithm_problem.cyc2018.tree;

/**
 * Created by GentleNi
 * Date 2019/3/18.
 */
public class Demo04_MergeTwoTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }
}
