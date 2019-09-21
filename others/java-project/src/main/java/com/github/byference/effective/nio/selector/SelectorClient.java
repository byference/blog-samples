package com.github.byference.effective.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * SelectorClient
 *
 * @author byference
 * @since 2019-09-21
 */
public class SelectorClient {

    public static void main(String[] args) throws Exception {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
        ByteBuffer writeBuffer = ByteBuffer.allocate(2014);
        writeBuffer.put("hello".getBytes());

        while (true) {
            writeBuffer.rewind();
            socketChannel.write(writeBuffer);
            Thread.sleep(1000);
        }
    }

}
