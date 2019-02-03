package com.gentleni.jianzhioffer;

import java.util.List;
import java.util.Stack;

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

        reverseList2(root);
    }

    }
