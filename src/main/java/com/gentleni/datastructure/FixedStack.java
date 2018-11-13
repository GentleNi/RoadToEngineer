package com.gentleni.datastructure;


/**
 * Created by GentleNi
 * Date 2018/11/13.
 */
public class FixedStack<Item> implements Stack<Item> {

    private Item[] items;
    private int N;

    FixedStack(int cap) {
        items = (Item[]) new Object[cap];//不能直接创建泛型数组
    }

    @Override
    public void push(Item item) {
        items[N++] = item;
    }

    @Override
    public Item pop() {
        return items[--N];
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
        FixedStack<String> stack = new FixedStack<>(3);
        stack.push("My");
        stack.push("name");
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
