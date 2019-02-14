package com.gentleni.jianzhioffer;

import java.util.jar.JarEntry;

/**
 * Created by GentleNi
 * Date 2019/2/12.
 */
public class Demo19_DeleteDuplication {


    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        if (head.val == next.val) {//第一个节点是重复节点，则跳过重复节点
            while (next != null && next.val == head.val)
                next = next.next;
            return deleteDuplication(next);
        } else {//第一个节点不是重复节点
            head.next = deleteDuplication(next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,null);
        ListNode node2 = new ListNode(2,null);
        ListNode node3 = new ListNode(2,null);
        ListNode node4 = new ListNode(3,null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Demo19_DeleteDuplication demo = new Demo19_DeleteDuplication();
        demo.deleteDuplication(node1);
        ListNode curr = node1;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}

  class ListNode {
    int val; // 结点的值
    ListNode next; // 下一个结点

      public ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }