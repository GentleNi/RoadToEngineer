package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/1/31.
 */
public class Demo08_TheNextNode {
     class TreeLinkNode {

        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;//祖先节点

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode getNextNode(TreeLinkNode pNode) {
         //如果节点右子树不为空，那么下一个节点是右子树的最左节点
         if (pNode.right != null) {
             TreeLinkNode node = pNode.right;
             while (node.left != null) {
                 node = node.left;
             }
             return node;
         } else {
             //右子树为空,递归回溯向上，找到第一个节点，这个节点的左子树包含刚刚右子树为空的那个节点
             while (pNode.next != null) {
                 TreeLinkNode parent = pNode.next;
                 if (parent.left == pNode) {
                     return parent;
                 }
                 pNode = pNode.next;
             }
         }
         return null;
    }
}
