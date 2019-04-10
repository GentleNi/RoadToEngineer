package com.gentleni.algorithm_problem.cyc2018.tree;

/**
 * Created by GentleNi
 * Date 2019/3/18.
 */
public class Demo09_MInDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) return left + right + 1;
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        System.out.println(new Demo09_MInDepth().minDepth(node1));
    }
}
