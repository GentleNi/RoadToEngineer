package com.gentleni.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.Signature;

/**
 * Created by GentleNi
 * Date 2018/10/9.
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        File f = new File("file\\test_file_channel.txt");
        File dir = f.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!f.exists()) {
            f.createNewFile();
        }
        RandomAccessFile aFile = new RandomAccessFile(f, "rw");
        FileChannel inChannel = aFile.getChannel();
        long fileSize = inChannel.size();
        System.out.println("file size is " + fileSize);
        String newString = "new String write to " + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();

        buf.put(newString.getBytes());

        buf.flip();

        while (buf.hasRemaining()) {
            inChannel.write(buf);
        }

        inChannel.close();
    }
}
