package com.gentleni.io.selector;

import sun.misc.Cleaner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;

/**
 * Created by GentleNi
 * Date 2018/11/2.
 */
public class SocketChannelDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        InetSocketAddress address = new InetSocketAddress("localhost",9888);
        SocketChannel client = SocketChannel.open(address);
        System.out.println("The Client is sending messages to server...");
        //Sending Message to the server
        while (true) {
            int order = new Random().nextInt(100);
            String message = "message " + order;
            byte[] byteMessage = message.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(byteMessage);
            //send message
            client.write(buffer);
            System.out.println(message);
            buffer.clear();
            Thread.sleep(3000);
        }

    }
}
