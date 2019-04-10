package com.gentleni.algorithm_problem.jianzhioffer;

import org.springframework.objenesis.instantiator.basic.NullInstantiator;

/**
 * Created by GentleNi
 * Date 2019/2/15.
 */
public class Demo28_Symmetrical {
    public boolean isSymmetrical(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetrical(root.left,root.right);
    }

    boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1==null && t2==null)
            return true;
        if (t1==null || t2==null)
            return false;
        if (t1.val != t2.val)
            return false;
        //下面这句是错的！！！
        //return isSymmetrical(t1.left,t1.right) && isSymmetrical(t2.left,t2.right);
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);

    }
}
