package com.gentleni.io.basicio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by GentleNi
 * Date 2019/2/3.
 */
public class CopyFileDemo {

    public static void copyFile(String src, String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);
        byte[] buffer = new byte[20 * 1024]; //20kb
        int cnt;
        while ((cnt = in.read(buffer,0,buffer.length)) != -1) {
            out.write(buffer,0,cnt);
        }

        in.close();
        out.close();
    }
}
