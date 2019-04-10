package com.gentleni.algorithm_problem.cyc2018.linkedlist;

/**
 * Created by GentleNi
 * Date 2019/3/19.
 */
public class Demo02_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode curr = head;
        while (curr.next != null) {
            curr.next = head.next;
            head.next = curr;
            curr = curr.next;
        }
        return newHead.next;
    }


}
