package com.gentleni.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by GentleNi
 * Date 2018/11/2.
 */
public class FileChannelTransferDemo {
    public static void main(String[] args) {
        String[] toFiles = new String[]{"dir01\\test01.txt","dir01\\test03.txt"};
        String fromFile = "dir02/test01_test03_merge.txt";
        try {
            transfer(toFiles,fromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  void transfer (String[] fromFiles, String toFile) throws IOException {
        FileOutputStream fos = new FileOutputStream(toFile);
        WritableByteChannel writerChanner = fos.getChannel();

        for (int i = 0; i < fromFiles.length; i++) {
            FileInputStream fis = new FileInputStream(fromFiles[i]);
            FileChannel inputChannel = fis.getChannel();

            inputChannel.transferTo(0,inputChannel.size(),writerChanner);

            inputChannel.close();
            fis.close();

        }
    }
}
