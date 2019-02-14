package com.gentleni.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/14.
 */
public class Demo23_EntryNodeOfLoop {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
