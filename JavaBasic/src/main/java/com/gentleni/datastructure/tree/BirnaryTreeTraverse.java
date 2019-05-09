package com.gentleni.datastructure.tree;


import com.gentleni.datastructure.linkedlist.LinkedListAlgo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/1/23.
 */
public class BirnaryTreeTraverse {

    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static List<TreeNode> nodeList = null;

    public static void main(String[] args) {
        BirnaryTreeTraverse birnaryTreeTraverse = new BirnaryTreeTraverse();
        TreeNode head  = birnaryTreeTraverse.createBinTree();
        System.out.println("递归先序遍历");
        preOrder(head);
        System.out.println();
        System.out.println("递归中序遍历");
        inOrder(head);
        System.out.println();
        System.out.println("递归后序遍历");
        postOrder(head);
    }

    //递归先序遍历
    public static void preOrder(TreeNode head) {
        if (head == null) return;
        System.out.print(head.val + "");
        preOrder(head.left);
        preOrder(head.right);
    }

    // 非递归先序遍历
    public static void preorderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print(node.val + " ");
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }
    //递归中序遍历
    public static void inOrder(TreeNode head) {
        if (head == null) return;
        inOrder(head.left);
        System.out.print(head.val + "");
        inOrder(head.right);
    }

    //递归先序遍历
    public static void postOrder(TreeNode head) {
        if (head == null) return;
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val + "");
    }



    // 建树
    public TreeNode createBinTree() {
        nodeList = new LinkedList<TreeNode>();
        for (int i = 0; i < array.length; i++)
            nodeList.add(new TreeNode(array[i]));

        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        int lastparentIndex = array.length / 2 - 1;
        nodeList.get(lastparentIndex).left = nodeList
                .get(lastparentIndex * 2 + 1);
        if (array.length % 2 == 1)
            nodeList.get(lastparentIndex).right = nodeList
                    .get(lastparentIndex * 2 + 2);

        return nodeList.get(0);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
        @Override
        public String toString(){
            return "val: "+val;
        }
    }

}
