package com.gentleni.datastructure.stack;

import java.util.Iterator;

/**
 * Created by GentleNi
 * Date 2018/11/13.
 */
public class LinkedStack<Item> implements Stack<Item>,Iterable{

    private Node first;//栈顶
    private int N;

    private class Node {
        Item item;
        Node next;
        Node (Item item) {};
    }

    @Override
    public void push(Item item) {
        Node old = first;
        first = new Node(item);
        first.next = old;
        N++;
    }

    @Override
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
