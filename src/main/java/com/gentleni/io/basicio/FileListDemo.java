package com.gentleni.io.basicio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Created by GentleNi
 * Date 2018/10/9.
 */
public class FileListDemo {
    public static void main(final String[] args) {
       listAllFiles(new File("C:\\OneDrive\\eBooks"));
    }

    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists())
            return;
        if (dir.isFile()) {
            System.out.println(dir.getParentFile() + "/" + dir.getName());
            return;
        } else {
            for(File f : dir.listFiles()) {
                listAllFiles(f);
            }
        }
    }
}
