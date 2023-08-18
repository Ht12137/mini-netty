package com.panika.test;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;


public class SimpleServer {



    public static void main(String[] args) throws IOException {

        System.out.println("这里是服务端");

        //创建服务端Channel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        //设置非阻塞
        serverChannel.configureBlocking(false);

        //创建Selector
        Selector selector = Selector.open();

        SelectionKey selectionKey = serverChannel.register(selector, 0, serverChannel);

        selectionKey.interestOps(SelectionKey.OP_ACCEPT);
        serverChannel.bind(new InetSocketAddress(8080));

        NioEventLoop executor = new NioEventLoop();

        //主线程负责连接
        while (true){
            //当没有事件到来的时候，这里是阻塞的,有事件的时候会自动运行
            selector.select();
            //如果有事件到来，这里可以得到注册到该selector上的所有的key，每一个key上都有一个channel
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //得到集合的迭代器
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                //得到每一个key
                SelectionKey key = keyIterator.next();
                //首先要从集合中把key删除，否则会一直报告该key
                keyIterator.remove();
                //接下来就要处理事件，判断selector轮询到的是什么事件，并根据事件作出回应
                //如果是连接事件
                if(key.isAcceptable()){
                    //之前把服务端channel注册到selector上时候，把serverChannel放进来了
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    //接收客户端channel
                    SocketChannel clientChannel = channel.accept();
                    clientChannel.configureBlocking(false);
                    SelectionKey clientSocketKey = clientChannel.register(selector, 0, clientChannel);
                    //将客户端channel设置为可读事件
                    clientSocketKey.interestOps(SelectionKey.OP_READ);
                    System.out.println("客户端连接成功"+System.currentTimeMillis());
                    //worker线程开始从客户端读数据，把客户端的channel交给worker
                    executor.register(clientChannel,executor);
                    //用channel写回一条信息
                    clientChannel.write(ByteBuffer.wrap("服务端写回客户端成功".getBytes()));
                    System.out.println("向客户端发送数据成功"+System.currentTimeMillis());
                }
            }
        }

    }
}
