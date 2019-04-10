package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/14.
 */
public class Demo25_MergeTowSortedList {

    public ListNode mergeList(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1,null);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null)
            cur.next = list1;
        if (list2 != null)
            cur.next = list2;
        return head.next;
    }
}
