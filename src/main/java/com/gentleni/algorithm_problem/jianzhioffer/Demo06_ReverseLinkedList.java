package com.gentleni.algorithm_problem.jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
public class Demo06_ReverseLinkedList {

    /**
     * 结点对象
     */
    public static class ListNode {
        int val; // 结点的值
        ListNode nxt; // 下一个结点
    }

    /**
     * 递归实现
     */
    public static void reverseList1(ListNode root) {
        if (root != null) {
            reverseList1(root.nxt);
            System.out.println(root.val + " ");
        }
    }

    /**
     * 使用栈
     * @param root
     */
    public static void reverseList2(ListNode root) {
        Stack<ListNode> stack = new Stack();
        while (root != null) {
            stack.push(root);
            root = root.nxt;
        }

        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.println(tmp.val + " ");
        }
    }

    public static ListNode reverseList3(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode curr = head;
        while (curr.nxt != null) {
            curr.nxt = head.nxt;
            head.nxt = curr;
            curr = curr.nxt;
        }
        return newHead.nxt;
    }


    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.nxt));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     * 使用头插法
     * @param args
     */

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.nxt = new ListNode();
        root.nxt.val = 2;
        root.nxt.nxt = new ListNode();
        root.nxt.nxt.val = 3;
        root.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.val = 4;
        root.nxt.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.nxt.val = 5;

        ArrayList<Integer> integers = printListFromTailToHead(root);
        for (Integer integer: integers) {
            System.out.println(integer);
        }

    }

    }
