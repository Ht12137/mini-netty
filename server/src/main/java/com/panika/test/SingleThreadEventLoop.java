package com.panika.test;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public abstract class SingleThreadEventLoop extends SingleThreadEventExecutor{

    private void register0(SocketChannel socketChannel,NioEventLoop nioEventLoop){
        try {
            socketChannel.configureBlocking(false);
            socketChannel.register(nioEventLoop.getSelector(), SelectionKey.OP_READ);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //注册socketChannel到当前的selector上
    public void register(SocketChannel socketChannel,NioEventLoop nioEventLoop){
        //先判断当前线程是否是执行器线程，如果不是，说明是主线程，那么就还没被构造。
        if(inEventLoop(Thread.currentThread())){
            register0(socketChannel,nioEventLoop);
        }else {
            //否则是第一次注册，就先构造线程即可。
            execute(()->{
                register0(socketChannel,nioEventLoop);
                System.out.println("executor执行完成");
            });
        }
    }


}
