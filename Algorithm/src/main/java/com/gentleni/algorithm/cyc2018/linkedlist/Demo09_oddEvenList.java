package com.gentleni.algorithm.cyc2018.linkedlist;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo09_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;
        ListNode odd = head, even = head.next,evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = even;
        return head;
    }
}
