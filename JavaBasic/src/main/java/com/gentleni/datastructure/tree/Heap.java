package com.gentleni.datastructure.tree;

import com.gentleni.datastructure.array.Array;

import java.util.Arrays;

/**
 * Created by GentleNi
 * Date 2019/1/24.
 */
public class Heap {
    private int[] a;
    private int n; //容量
    private int count; //当前存储个数

    public int[] getA() {
        return a;
    }

    public Heap(int capacity) {
        a = new int[capacity];
        count = 0;
        n = capacity;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(16);
        heap.insert(12);
        heap.insert(2);
        heap.insert(6);
        heap.insert(7);
        heap.insert(34);
        heap.insert(1);
        System.out.println(Arrays.toString(heap.getA()));
        heap.removeMax();
        heap.removeMax();
        heap.removeMax();
        System.out.println(Arrays.toString(heap.getA()));

    }

    public void insert(int val) {
        if (count >= n) return;
        a[++count] = val;
        int i = count;

        //从下往上堆化
        while (i/2 > 0 && a[i] > a[i/2]) {
            swap(a,i,i/2);
            i = i/2;
        }
    }

    public void removeMax() {
        if (count == 0) return ;
        a[1] = a[count];
        a[count] = 0;
        --count;
        heapify(a,n,1);
    }

    //堆化
    private void heapify(int[] a ,int n,int i) {
        while (true) {
            int maxPos = i;
            //找出左右两个子节点其中大的一个
            if (i * 2 <= n && a[i] < a[i*2]) maxPos = i *2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(a,maxPos,i);
            i = maxPos;

        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[i/2];
        a[i/2] = tmp;
    }
}
