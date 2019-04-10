package com.gentleni.algorithm_problem.cyc2018.linkedlist;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo03_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (l1.next != null && l2.next != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1.next != null) {
            curr.next = l1;
        }

        if (l2.next != null) {
            curr.next = l2;
        }
        return head.next;
    }
}
