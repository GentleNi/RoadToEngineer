package com.gentleni.datastructure.queue;

/**
 * Created by GentleNi
 * Date 2018/11/14.
 */
public interface Queue<Item> {
    void enqueue(Item item);
    Item dequeue();
    boolean isEmpty();
    int size();
}
