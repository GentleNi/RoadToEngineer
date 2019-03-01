package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/25.
 */
public class Demo68_LowestCommonAncestor {
    //如果是二叉排序树
    //那么两个结点或是root.val >= p.val && root.val <= q.val。
    //或者是倒过来
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
