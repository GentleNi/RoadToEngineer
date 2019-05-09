package com.gentleni.algorithm.basic.tree;

/**
 * Created by GentleNi
 * Date 2019/3/5.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x){
        val=x;
    }

    @Override
    public String toString(){
        return "val: "+val;
    }

    public void visit(TreeNode node){
        System.out.print(node.val+" ");
    }
}
