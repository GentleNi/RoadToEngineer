package com.gentleni.datastructure.lru;

import java.util.HashMap;

/**
 * Created by GentleNi
 * Date 2019/3/28.
 */
public class LRUCache<K,V> {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node newNode = new Node(key,value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(newNode);
            } else {
                setHead(newNode);
            }
            map.put(key,newNode);
        }
    }


    public void remove(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            end = node.pre;
        }
    }

    public void setHead(Node node){
        node.next  = head;
        node.pre = null;

        if (head != null) {
            head.pre = node;
        }

        head = node;

        if (end == null)
            end = head;
    }



    private class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
