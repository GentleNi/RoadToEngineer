package com.gentleni.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/3/5.
 */
public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null)
            return list;
        TreeNode cur = root;

        while (cur != null ||!stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
