package com.github.byference.effective.nio.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * WebClient
 *
 * @author byference
 * @since 2019-09-21
 */
public class WebClient {


    public static void main(String[] args) throws Exception {

        // 获得一个socketChannel（未连接）
        try (SocketChannel socketChannel = SocketChannel.open()) {

            // 给该通道对应的socket进行连接操作
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            ByteBuffer buffer2 = ByteBuffer.allocate(1024);
            buffer1.put("hello, world. ".getBytes());
            buffer2.put("hello, nio. ".getBytes());
            buffer1.flip();
            buffer2.flip();

            // Scatter / Gather
            socketChannel.write(new ByteBuffer[]{buffer1, buffer2});
        }
    }

}
