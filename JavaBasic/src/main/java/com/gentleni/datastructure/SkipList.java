package com.gentleni.datastructure;

/**
 * Created by GentleNi
 * Date 2019/1/22.
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    public class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

}
