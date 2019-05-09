package com.gentleni.io.basicio;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by GentleNi
 * Date 2018/10/9.
 */
public class SortedDirList {
    private String[] dirList;

    public SortedDirList(File dir) {
        dirList = dir.list();
        Arrays.sort(dirList,String.CASE_INSENSITIVE_ORDER);
    }

    public String[] list() {
        return dirList;
    }

    public String[] list(String regex) {
        Pattern pattern = Pattern.compile(regex);
        List<String> sList = new ArrayList<String>();
        int count = 0;
        for (String s : dirList) {
            if (pattern.matcher(s).matches()) {
                count++;
                sList.add(s);
            }
        }
        return sList.toArray(new String[count]);
    }

    public static void main(String[] args) {
        SortedDirList sortedDirList = new SortedDirList(new File("."));
        for (String file : sortedDirList.dirList) {
            System.out.println(file);
        }
        System.out.println("----------------------------");

        for (String file : sortedDirList.list(".+\\.xml")) {
            System.out.println(file);
        }
    }
}
