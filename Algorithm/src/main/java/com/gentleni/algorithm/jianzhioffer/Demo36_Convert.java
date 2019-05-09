package com.gentleni.algorithm.jianzhioffer;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 * Created by GentleNi
 * Date 2019/3/21.
 */
public class Demo36_Convert {

    TreeNode pre = null;
    TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre =  node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }
}
