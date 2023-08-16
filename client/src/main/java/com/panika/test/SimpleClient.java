package com.panika.test;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class SimpleClient {

    public static void main(String[] args) throws IOException {


        //得到客户端的channel
        SocketChannel clientChannel = SocketChannel.open();
        //设置非阻塞
        clientChannel.configureBlocking(false);

        //得到selector
        Selector selector = Selector.open();

        //将selector注册到channel
        SelectionKey selectionKey = clientChannel.register(selector, 0);

        //设置事件
        selectionKey.interestOps(SelectionKey.OP_CONNECT);

        clientChannel.connect(new InetSocketAddress(8080));


        while (true){
            //无事件就阻塞
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                //如果连接成功事件
                if(key.isConnectable()){
                    if(clientChannel.finishConnect()){
                        clientChannel.register(selector,SelectionKey.OP_READ);
                        System.out.println("成功注册读事件");
                        //向服务端发信息
                        clientChannel.write(ByteBuffer.wrap("客户端正在发送".getBytes()));
                    }
                }

                if(key.isReadable()){
                    SocketChannel channel = (SocketChannel)key.channel();
                    //分配字节缓冲区来接收服务端传过来的数据。
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = channel.read(buffer);
                    byte[] readByte = new byte[len];
                    buffer.flip();
                    buffer.get(readByte);
                    System.out.println("读到来自服务端的数据，" + new String(readByte));
                }
            }

        }

    }
}
