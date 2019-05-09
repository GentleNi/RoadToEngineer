package com.gentleni.algorithm.cyc2018.linkedlist;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo05_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null)
            return head.next;//相当于伤了第一个
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;

    }
}