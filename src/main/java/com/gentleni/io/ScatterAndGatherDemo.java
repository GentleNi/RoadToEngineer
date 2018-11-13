package com.gentleni.io;

import java.io.*;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by GentleNi
 * Date 2018/11/2.
 */
public class ScatterAndGatherDemo {
    public static void main(String[] args) {
        gatherBytes("dir01\\test02.txt","yes no");
        scatterBytes("dir01\\test02.txt");
    }

    public static void gatherBytes(String dir , String data) {
        Path path = Paths.get(dir);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        ByteBuffer buffer2 = ByteBuffer.allocate(400);

        buffer1.asIntBuffer().put(100);
        buffer2.asCharBuffer().put(data);

        GatheringByteChannel gatheringByteChannel = createChannelInstance(dir,true);

        try {
            gatheringByteChannel.write(new ByteBuffer[]{buffer1,buffer2});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void scatterBytes(String dir) {
        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        ByteBuffer buffer2 = ByteBuffer.allocate(400);

        ScatteringByteChannel scatteringByteChannel = createChannelInstance(dir,false);

        try {
            scatteringByteChannel.read(new ByteBuffer[]{buffer1,buffer2});
        } catch (IOException e) {
            e.printStackTrace();
        }

        buffer1.rewind();
        buffer2.rewind();

        int bufferOne = buffer1.asIntBuffer().get();
        String bufferTwo = buffer2.asCharBuffer().toString();

        //Verification of content
        System.out.println(bufferOne);
        System.out.println(bufferTwo);
    }
    //Create FileChannel
    public static FileChannel createChannelInstance(String file, boolean isOutput) {
        FileChannel fileChannel = null;
        try {
            if (isOutput) {
                fileChannel = new FileOutputStream(file).getChannel();
            } else {
                fileChannel = new FileInputStream(file).getChannel() ;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileChannel;
    }
}
