package com.gentleni.algorithm_problem.jianzhioffer;

import javax.crypto.spec.DESedeKeySpec;

/**
 * Created by GentleNi
 * Date 2019/2/18.
 */
public class Demo37_SerializeAndDeserialize {
    private String deserializeStr;

    public String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0 || deserializeStr.equals("#"))
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0,index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index+1);
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }
}
