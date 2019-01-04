package com.gentleni.datastructure.stack;

/**
 * Created by GentleNi
 * Date 2018/11/13.
 */
public class AutoExpandStack<Item> implements Stack<Item> {
    private Item[] items;
    private int N;

    AutoExpandStack(int cap) {
        items = (Item[]) new Object[cap];//不能直接创建泛型数组
    }

    @Override
    public void push(Item item) {
        if (N == items.length) resize(2 * items.length);
        items[N++] = item;
    }

    @Override
    public Item pop() {
        Item item = items[--N];
        items[N] = null;//垃圾回收
        if (N > 0 && N == items.length/4) resize(2 * items.length);
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

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N;i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public static void main(String[] args) {
        AutoExpandStack<String> stack = new AutoExpandStack<>(2);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        System.out.println(stack.size());
    }
}
