package com.gentleni.algorithm_problem.cyc2018.tree;

/**
 * Created by GentleNi
 * Date 2019/3/30.
 */
public class Demo17_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return null;
        int mid = startIndex + (endIndex - startIndex) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums,startIndex,mid-1);
        root.right = toBST(nums,mid+1,endIndex);
        return root;
    }

}
