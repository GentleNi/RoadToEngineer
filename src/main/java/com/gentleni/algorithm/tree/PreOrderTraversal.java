package com.gentleni.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/3/5.
 */
public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>  resultList = new ArrayList<>();
        Stack<TreeNode> treeStack = new Stack<>();
        if(root == null)
            return resultList;
        treeStack.add(root);
        while (!treeStack.isEmpty()) {
            TreeNode node = treeStack.pop();
            if (node != null) {
                resultList.add(node.val);
                treeStack.add(node.right);
                treeStack.add(node.left);
            }
        }
        return resultList;
    }


}
