package com.gentleni.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by GentleNi
 * Date 2018/10/9.
 */
public class ChannelDemo {
    public static void main(String[] args) throws IOException {

        File f = new File("test.txt");
        if (!f.exists()) {
            System.out.println("file not exist,create file: ");
            f.createNewFile();
        } else {
            System.out.println("file exist: " + f.getAbsolutePath());
        }

        RandomAccessFile rFile = new RandomAccessFile(f,"rw");
        FileChannel channel = rFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = channel.read(buf);

        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = channel.read(buf);
        }

        rFile.close();
    }
}
