package com.gentleni.algorithm.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/18.
 */
public class Demo36_ConvertBinary {
    //双向链表的左边头结点和右边头节点
    TreeNode leftHead = null;
    TreeNode rightHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        //递归调用叶子节点的左右节点返回null
        if(pRootOfTree==null) return null;
        //第一次运行时，它会使最左边叶子节点为链表第一个节点
        Convert(pRootOfTree.left);
        if (leftHead == null) {
            leftHead = pRootOfTree;
            rightHead = pRootOfTree;
        } else {
            //把根节点插入到双向链表右边，rightHead向后移动
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        //把右叶子节点也插入到双向链表（rightHead已确定，直接插入）
        Convert(pRootOfTree.right);
        //返回左边头结点
        return leftHead;
    }

}
