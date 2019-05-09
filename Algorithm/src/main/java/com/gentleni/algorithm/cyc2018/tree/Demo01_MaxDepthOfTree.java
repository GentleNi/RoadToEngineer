package com.gentleni.algorithm.cyc2018.tree;

/**
 * Created by GentleNi
 * Date 2019/3/18.
 */
public class Demo01_MaxDepthOfTree {
    public int maxDepth(TreeNode root) {
        if (root == null )
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
