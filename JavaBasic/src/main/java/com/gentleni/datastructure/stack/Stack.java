package com.gentleni.datastructure.stack;


/**
 * Created by GentleNi
 * Date 2018/11/13.
 */
public interface Stack<Item> {
    void push(Item item);
    Item pop();
    boolean isEmpty();
    int size();
}
