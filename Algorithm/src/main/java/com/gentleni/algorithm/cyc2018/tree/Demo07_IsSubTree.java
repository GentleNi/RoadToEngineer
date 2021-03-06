package com.gentleni.algorithm.cyc2018.tree;

/**
 * Created by GentleNi
 * Date 2019/3/18.
 */
public class Demo07_IsSubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return dosSubTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    private boolean dosSubTree (TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return dosSubTree(s.left,t.left) && dosSubTree(s.right,t.right);

    }
}
