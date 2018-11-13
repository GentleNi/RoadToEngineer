package com.gentleni.io.selector;

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.misc.Cleaner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by GentleNi
 * Date 2018/11/2.
 */
public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException {
        // Get the selector
        Selector selector = Selector.open();
        System.out.println("Selector is open for making connection: " + selector.isOpen());
        //open a ServerSocketChannel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost",9888);
        //bind and listening
        serverChannel.bind(hostAddress);
        serverChannel.configureBlocking(false);

        //get all the valid operations server support
        int ops = serverChannel.validOps();
        serverChannel.register(selector,ops,null);

        while (true) {
            System.out.println("Waiting for connect");
            int noOfKeys = selector.select();
            System.out.println("The number of select is " + noOfKeys);
            Set selectedKeys = selector.selectedKeys();

            Iterator iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                if (key.isAcceptable()) {
                    //new connection is accepted
                    SocketChannel client = serverChannel.accept();
                    client.configureBlocking(false);
                    //new connection is added to a selector
                    client.register(selector,SelectionKey.OP_READ);
                    System.out.println("The new connection is accepted from the client: " + client);
                } else if (key.isReadable()) {
                    //Data is read from the client
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    client.read(buffer);
                    String message = new String(buffer.array()).trim();
                    System.out.println("Received Message From Client: " + message);
                    if ("bye".equals(message)) {
                        client.close();
                        System.out.println("Client Request Disconnect!");
                    }
                }
                iterator.remove();
            }//end of the while loop
        }
    }
}
