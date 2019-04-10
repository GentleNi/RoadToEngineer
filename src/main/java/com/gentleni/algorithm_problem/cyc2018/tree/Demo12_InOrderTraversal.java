package com.gentleni.algorithm_problem.cyc2018.tree;

import org.springframework.util.CollectionUtils;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by GentleNi
 * Date 2019/3/18.
 */
public class Demo12_InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;
        }
        return  ret;
    }
}
