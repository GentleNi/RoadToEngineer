package com.gentleni.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Created by GentleNi
 * Date 2018/10/9.
 */
public class FileListDemo {
    public static void main(final String[] args) {
        File path = new File(".");
        String[] list;
        list = path.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
