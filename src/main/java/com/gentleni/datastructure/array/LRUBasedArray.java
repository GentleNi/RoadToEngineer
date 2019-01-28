package com.gentleni.datastructure.array;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GentleNi
 * Date 2019/1/15.
 */
public class LRUBasedArray<T> {
    /**
     * 基于数组实现的LRU缓存
     * 1. 空间复杂度为O(n)
     * 2. 时间复杂度为O(n)
     * 3. 不支持null的缓存
     */

    private static final int DEFAULT_CAPACITY = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    //实现数组的O(1)查找，储存object的index
    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        value =(T[]) new Object[capacity];
        holder = new HashMap<T,Integer>(capacity);
    }

    /**
     * 模拟访问某个值
     * @param object
     */
    public void offer(T object) {
        Integer index = holder.get(object);

        if (index == null) {//缓存中不存在
            if(isFull()) {//缓存满了
                //淘汰数组末端，并把object加入数组头
                removeAndCache(object);
            } else {
                cache(object,count);
            }
        } else {
            update(index);
        }
    }


    //缓存中没有，且队列没满
    public void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object,0);
        count++;
    }

    //缓存中没有，且队列满了，需要淘汰一个
    public void removeAndCache(T object) {
        value[--count] = null;
        cache(object, count);
    }

    //缓存中有，直接替换
    public void update(int end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target,0);
    }

    /**
     * 把end左边的数据都向右移动一位
     * @param end
     */
    public void rightShift(int end) {
        for(int i = end -1; i >=0; i--) {
           value[i + 1] = value[i];
           holder.put(value[i],i+1);
        }
    }
    /**
     * 返回是不是缓存已满
     * @return
     */
    public boolean isFull() {
        return capacity == count;
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
//            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}
