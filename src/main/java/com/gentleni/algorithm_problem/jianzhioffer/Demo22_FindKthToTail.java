package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/14.
 */
public class Demo22_FindKthToTail {

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode P1 = head;
        while (P1 != null && k-- > 0)
            P1 = P1.next;
        if (k > 0)
            return null;
        ListNode P2 = head;
        while (P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }
}
