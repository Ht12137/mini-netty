package com.panika.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class Worker implements Runnable {


    Selector selector;

    SocketChannel clientChannel;

    Thread thread;

    //构造器让读线程拥有自己的channel和selector
    public Worker() {
        try {
            this.clientChannel = SocketChannel.open();
            this.selector = Selector.open();
            thread = new Thread(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //当主线程把客户端channel交给worker线程的seletor管理,然后交给该线程去处理读事件
    public void register(SocketChannel clientChannel) throws ClosedChannelException {
        this.clientChannel = clientChannel;
        clientChannel.register(selector, SelectionKey.OP_READ);
        this.thread.start();
    }

    //读线程只负责读
    @Override
    public void run() {
        while (true) {
            try {
                selector.select();
                for (SelectionKey key : selector.selectedKeys()) {
                    //由于连接事件被处理完了，只剩下只读事件了
                    if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len = 0;
                        len = socketChannel.read(buffer);
                        if (len == -1) {
                            socketChannel.close();
                            break;
                        } else {
                            buffer.flip();
                            System.out.println(Charset.defaultCharset().decode(buffer).toString() + System.currentTimeMillis());
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
