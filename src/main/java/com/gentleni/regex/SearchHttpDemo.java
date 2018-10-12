package com.gentleni.regex;

import java.util.regex.Pattern;

/**
 * Created by GentleNi
 * Date 2018/10/12.
 */
public class SearchHttpDemo {
    public static void main(String[] args) {
        String text    =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";

        String regex = ".*http://.*";
        boolean matches = Pattern.matches(regex,text);
        System.out.println("matches = " +  matches);
    }
}
