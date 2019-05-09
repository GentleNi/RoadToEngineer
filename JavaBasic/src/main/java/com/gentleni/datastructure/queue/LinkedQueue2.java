package com.gentleni.datastructure.queue;

/**
 * Created by GentleNi
 * Date 2019/1/16.
 */
public class LinkedQueue2 {
    // 队列的队首和队尾
    private Node head = null;
    private Node tail = null;

    //入队
    public boolean enqueue(String value) {
        if(tail == null) {
            Node node = new Node(value,null);
            head = node;
            tail = node;
        } else {
            tail.next = new Node(value,null);
            tail = tail.next;
        }
        return true;
    }

    //出队
    public String dequeue() {
        if(head == null) return null;
        String ret = head.data;

        head = head.next;
        if(head == null){
            tail = null;
        }
        return ret;
    }


    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}
