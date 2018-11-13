package com.gentleni.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by GentleNi
 * Date 2018/11/2.
 */
public class FileChannelCopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("dir01/test01.txt");
        ReadableByteChannel source = fis.getChannel();
        FileOutputStream fos = new FileOutputStream("dir02/test01_copy.txt");
        WritableByteChannel target = fos.getChannel();
        copyData(source,target);
        source.close();
        target.close();

    }

    private static void copyData (ReadableByteChannel source , WritableByteChannel target) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (source.read(buffer) != -1) {//向buffer写
            //从buffer读
            buffer.flip();
            while (buffer.hasRemaining()) {
                target.write(buffer);
            }
            buffer.clear();
        }
    }
}
