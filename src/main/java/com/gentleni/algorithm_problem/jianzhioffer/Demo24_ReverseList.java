package com.gentleni.algorithm_problem.jianzhioffer;

import javafx.scene.chart.BubbleChart;

/**
 * Created by GentleNi
 * Date 2019/2/14.
 */
public class Demo24_ReverseList {

    //1->2->3
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;//head 是 2, head.next是3,3.next = 2
        head.next = null;//2.next = null，去掉环
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
