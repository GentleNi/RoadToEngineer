package com.gentleni.datastructure.stack;

/**
 * Created by GentleNi
 * Date 2019/1/16.
 */
public class LinkedStack2 {
    private Node top = null;
    private int N;


    public void push(int val) {
        Node newNode = new Node(val,null);
        if(top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) return -1;
        int val = top.data;
        top = top.next;
        return val;
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
