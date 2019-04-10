package com.gentleni.algorithm_problem.cyc2018.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/3/18.
 */
public class Demo11_PrrOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null)
                continue;
            ret.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return ret;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(null);
        stack.push(null);
        stack.push(null);
        System.out.println(stack.size());
    }
}
