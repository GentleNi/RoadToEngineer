package com.gentleni.algorithm_problem.cyc2018.tree;

import com.sun.jndi.cosnaming.CNCtx;

/**
 * Created by GentleNi
 * Date 2019/3/29.
 */
public class Demo14_FindKElement {
    private int cnt = 0;
    private int val;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null)
            return;
        inOrder(node.left,k);
        cnt++;
        if (cnt == k) {
            val  = node.val;
            return;
        }
        inOrder(node.right,k);
    }
}
