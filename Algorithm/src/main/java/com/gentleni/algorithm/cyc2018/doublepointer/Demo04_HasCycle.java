package com.gentleni.algorithm.cyc2018.doublepointer;

import com.gentleni.algorithm.cyc2018.linkedlist.ListNode;

/**
 * Created by GentleNi
 * Date 2019/3/26.
 */
public class Demo04_HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
}
