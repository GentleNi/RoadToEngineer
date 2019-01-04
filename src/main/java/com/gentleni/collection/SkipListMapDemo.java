package com.gentleni.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by GentleNi
 * Date 2018/12/20.
 */
public class SkipListMapDemo {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, Integer> skipListMap = new ConcurrentSkipListMap<>();
        for (int i = 0; i < 100; i++) {
            skipListMap.put(i,i);
        }
        for (Map.Entry<Integer,Integer> entry : skipListMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
