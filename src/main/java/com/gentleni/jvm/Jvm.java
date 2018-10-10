package com.gentleni.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GentleNi
 * Date 2018/9/14.
 */
public class Jvm {
    static class OomPbject {
        OomPbject() {
            System.out.println("oom");
        }
    }

    public static void main(String[] args) {
        List<OomPbject> oomList = new ArrayList();
        while(true) {
            oomList.add(new OomPbject());
        }
    }
}
