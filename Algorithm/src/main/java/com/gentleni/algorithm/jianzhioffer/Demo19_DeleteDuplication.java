package com.gentleni.algorithm.jianzhioffer;

import java.util.jar.JarEntry;

/**
 * Created by GentleNi
 * Date 2019/2/12.
 */
public class Demo19_DeleteDuplication {


    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }

    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        ListNode curr = pHead;
        ListNode next = pHead.next;
        while (curr != null && next != null) {
            if (curr.val == next.val) {//如果和后继结点相等
                while (next.next != null && next.val == next.next.val) {
                    next = next.next;
                }
                next = next.next;
                curr.next = next;
            } else {
                curr = curr.next;
                next = next.next;
            }
        }
        return pHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,null);
        ListNode node2 = new ListNode(2,null);
        ListNode node3 = new ListNode(2,null);
        ListNode node4 = new ListNode(3,null);
        ListNode node5 = new ListNode(3,null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Demo19_DeleteDuplication demo = new Demo19_DeleteDuplication();
        demo.deleteDuplication2(node1);
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