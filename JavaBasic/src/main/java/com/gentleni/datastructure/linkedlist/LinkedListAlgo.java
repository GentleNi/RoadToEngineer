package com.gentleni.datastructure.linkedlist;

import org.junit.Test;

import javax.print.attribute.standard.NumberOfInterveningJobs;

/**
 * Created by GentleNi
 * Date 2019/1/15.
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 */
public class LinkedListAlgo {

    //单链表反转
    public static Node reverse(Node head) {
        if (head == null || head.next == null)
            return null;
        Node headNode = new Node(-1,null);
        Node currNode = head;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = headNode.next;
            headNode.next = currNode;
            currNode = nextNode;
        }
        return headNode.next;

    }

    //检测环
    public static boolean checkCircle(Node list) {
        if (list == null)
            return false;

        Node fast = list;
        Node slow = list;

        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;
        }
        return false;

    }

    public static void main(String[] args) {
        //Test Reverse
        Node n1 = new Node(1,null);
        Node n2 = new Node(2,null);
        Node n3 = new Node(3,null);
        Node n4 = new Node(4,null);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        iterateList(reverse(n1));
    }

    @Test
    public  void testCircle(){
        Node n1 = new Node(1,null);
        Node n2 = new Node(2,null);
        Node n3 = new Node(3,null);
        Node n4 = new Node(4,null);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n1);
        System.out.println(checkCircle(n1));
    }

    public static void iterateList(Node first) {
        //Iterate the LinkedList
        Node p = first;
        while (p.next != null) {
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println(p.getData());
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
