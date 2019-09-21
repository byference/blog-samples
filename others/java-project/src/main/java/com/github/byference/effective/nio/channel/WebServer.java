package com.github.byference.effective.nio.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * WebServer
 *
 * @author byference
 * @since 2019-09-21
 */
public class WebServer {


    public static void main(String[] args) throws Exception {

        // 获得一个serverSocketChannel
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            // 给该通道对应的serverSocket绑定上端口
            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8080));
            try (SocketChannel socketChannel = serverSocketChannel.accept()) {

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                socketChannel.read(buffer);

                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
            }
        }
    }

}
