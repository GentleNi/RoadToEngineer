package com.gentleni.algorithm.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/12.
 */
public class Demo18_DeleteNode {
    /**
     * 结点对象
     */
    public  class ListNode {
        int val; // 结点的值
        ListNode nxt; // 下一个结点
    }

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return null;
        if (tobeDelete.nxt != null) {
            ListNode next = tobeDelete.nxt;
            tobeDelete.val = next.val;
            tobeDelete.nxt = next.nxt;
        } else {
            ListNode cur = head;
            while (cur.nxt != tobeDelete) {
                cur = cur.nxt;
            }
            cur.nxt = null;
        }
        return head;
    }
}
