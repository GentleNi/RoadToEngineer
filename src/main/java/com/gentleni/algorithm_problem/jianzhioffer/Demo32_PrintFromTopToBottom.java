package com.gentleni.algorithm_problem.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by GentleNi
 * Date 2019/2/15.
 */
public class Demo32_PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null)
            return list;
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode tmp = queue.remove(0);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            list.add(tmp.val);
        }
        return list;
    }
}
