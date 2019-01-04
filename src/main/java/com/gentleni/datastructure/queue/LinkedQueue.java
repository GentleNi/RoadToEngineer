package com.gentleni.datastructure.queue;


/**
 * Created by GentleNi
 * Date 2018/11/14.
 */
public class LinkedQueue<Item> implements Queue<Item> {

    private Node first;//队首
    private Node last;//队尾
    private int N;

    private class Node {
        Item item;
        Node next;
        Node (Item item) {this.item = item;}
    }

    @Override
    public void enqueue(Item item) {
        //向队尾添加元素
        Node old = last;
        last = new Node(item);
        last.next = null;
        if (isEmpty())
            first = last;
        else
            old.next = last;
        N++;
    }

    @Override
    public Item dequeue() {
        //从队首删除元素
        Node old = first;
        first = first.next;
        old.next = null;
        if (isEmpty())
            last = null;
        N--;
        return old.item;

    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
    }
}
