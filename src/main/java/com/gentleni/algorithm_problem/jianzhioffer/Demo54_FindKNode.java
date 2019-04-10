package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 */
public class Demo54_FindKNode {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k)
            return;
        inOrder(root.left,k);
        cnt++;
        if (cnt == k)
            ret = root;
        inOrder(root.right,k);

    }
}
