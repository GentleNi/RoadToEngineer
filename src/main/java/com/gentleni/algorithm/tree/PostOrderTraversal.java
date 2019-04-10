package com.gentleni.algorithm.tree;

import java.util.*;

/**
 * Created by GentleNi
 * Date 2019/3/5.
 */
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                ret.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        Collections.reverse(ret);
        return ret;
    }

}
