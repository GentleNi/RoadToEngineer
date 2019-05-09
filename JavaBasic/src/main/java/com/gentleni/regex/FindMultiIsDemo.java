package com.gentleni.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by GentleNi
 * Date 2018/10/12.
 */
public class FindMultiIsDemo {
    public static void main(String[] args) {
        String text    =
                "This is the text which is to be searched " +
                        "for occurrences of the word 'is'.";

        String regex = "is";
        Pattern pattern = Pattern.compile("is");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher.start() + " - " + matcher.end());
        }
    }
}
