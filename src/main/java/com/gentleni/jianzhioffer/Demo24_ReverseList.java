package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/14.
 */
public class Demo24_ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(next);
        next.next = head;
        return newHead;
    }

    public ListNode ReverseList(ListNode head) {
        ListNode newList = new ListNode(-1,null);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }
}
