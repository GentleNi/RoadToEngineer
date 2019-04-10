package com.gentleni.algorithm_problem.cyc2018.linkedlist;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo01_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
