package com.gentleni.algorithm.cyc2018.linkedlist;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo04_DeleteDuplatesNode {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        return head.next.val == head.val ? head.next : head;
    }
}
