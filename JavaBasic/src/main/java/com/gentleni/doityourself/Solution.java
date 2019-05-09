package com.gentleni.doityourself;

/**
 * Created by GentleNi
 * Date 2019/2/26.
 */

public class Solution {



}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
class ListNode {
    int val; // 结点的值
    ListNode next; // 下一个结点

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}