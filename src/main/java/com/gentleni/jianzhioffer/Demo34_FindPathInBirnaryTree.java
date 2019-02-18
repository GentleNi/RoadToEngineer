package com.gentleni.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by GentleNi
 * Date 2019/2/17.
 */
public class Demo34_FindPathInBirnaryTree {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        backtracking(root,target,new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        target = target - node.val;
        //满足条件的话就加入集合
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(path);
        } else {
            backtracking(node.left,target,path);
            backtracking(node.right,target,path);
        }
        path.remove(ret.size() - 1);
    }

}
