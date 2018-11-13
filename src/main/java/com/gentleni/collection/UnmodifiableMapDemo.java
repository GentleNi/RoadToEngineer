package com.gentleni.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;

/**
 * Created by GentleNi
 * Date 2018/11/5.
 */
public class UnmodifiableMapDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<String,String> maps = new ConcurrentHashMap<>();
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(maps);
        maps.put("key1","value1");

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new writeTask(maps));
        Thread.sleep(1000);
        service.submit(new ReadTask(maps,unmodifiableMap));

    }

}

class ReadTask implements Runnable {
    Map<String,String> map;
    Map<String,String> unmodifiableMap;
    ReadTask(Map map,Map unmodifiableMap) {
        this.map = map;
        this.unmodifiableMap = unmodifiableMap;
    }

    @Override
    public void run() {
        while(true) {
            String value = map.get("key1");
            String valueOnView = unmodifiableMap.get("key1");
            System.out.println(value);
            System.out.println(valueOnView);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class writeTask implements Runnable {
    Map<String,String> map;
    int i = 0;

    writeTask(Map map) {
        this.map = map;
    }

    @Override
    public void run() {
        while(true) {
            map.put("key1",(++i) + "");
            System.out.println("set value + 1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}