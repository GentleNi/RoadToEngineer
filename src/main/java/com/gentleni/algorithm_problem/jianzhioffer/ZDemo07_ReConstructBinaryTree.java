package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/21.
 */
public class ZDemo07_ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }


    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (i == pre[startPre]) {//在中序遍历结果中找到根节点
                root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right = reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }

}
