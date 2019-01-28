package com.gentleni.datastructure.array;

import java.util.concurrent.Callable;

/**
 * Created by GentleNi
 * Date 2019/1/15.
 */
public class Array {

    //数组数据
    private int[] data;
    //数组长度
    private int n;
    //数组实际长度
    private int count;

    public Array(int capacity) {
        this.n = capacity;
        this.data = new int[capacity];
        this.count = 0;
    }

    public int  find(int index) {
        if (index < 0 || index >= n) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        // 数组空间已满
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }

        if (index < 0 || index >= n) {
            return false;
        }

        if (index == n-1) {
            data[index] = value;
        }

        for (int i = count; i >index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }

    //根据索引，删除数组中元素
    public boolean delete(int index){
        if (index<0 || index >=count) return false;
        //从删除位置开始，将后面的元素向前移动一位
        for (int i=index+1; i<count; ++i){
            data[i-1] = data[i];
        }
        //删除数组末尾元素  这段代码不需要也可以
        /*int[] arr = new int[count-1];
        for (int i=0; i<count-1;i++){
            arr[i] = data[i];
        }
        this.data = arr;*/


        --count;
        return true;
    }
    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }

}
