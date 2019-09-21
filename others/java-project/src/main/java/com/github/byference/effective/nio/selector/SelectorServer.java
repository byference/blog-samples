package com.github.byference.effective.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * SelectorServer
 *
 * @author byference
 * @since 2019-09-21
 */
public class SelectorServer {

    public static void main(String[] args) throws Exception {

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8080));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            writeBuffer.put("received".getBytes());
            writeBuffer.flip();

            while (true) {

                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();

                    if (selectionKey.isAcceptable()) {

                        // 创建新连接并注册到selector上
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {

                        // isReadable 读出数据，并且将兴趣事件改为写
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        readBuffer.clear();
                        socketChannel.read(readBuffer);

                        readBuffer.flip();
                        System.out.println("received: " + new String(readBuffer.array()));
                        selectionKey.interestOps(SelectionKey.OP_WRITE);
                    } else if (selectionKey.isWritable()) {

                        // isWritable 写入数据，并且将兴趣事件改为读
                        writeBuffer.rewind();
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        socketChannel.write(writeBuffer);
                        selectionKey.interestOps(SelectionKey.OP_READ);
                    }
                }
            }
        }
    }
}
