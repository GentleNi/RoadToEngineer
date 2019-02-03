package com.gentleni.io.nio;

import java.io.*;

/**
 * Created by GentleNi
 * Date 2018/10/9.
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
