package com.panika.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NioEventLoop extends SingleThreadEventLoop{

    protected Selector selector ;

    public NioEventLoop() throws IOException {
        this.selector = Selector.open();
    }

    public Selector getSelector(){
        return this.selector;
    }

    //循环阻塞，如果有事件发生，或者队列有东西，就放行
    private void select() throws IOException {
        while (true){
            //阻塞等待事件，如果3s都没有事件过来，可能是没有初始化。
            int select = selector.select(3000);
            if(select != 0 || hasTasks()){
                break;
            }
        }
    }

    private void runAllTasks() {

        for (;;){
            Runnable task = tasksQueue.poll();
            if(task == null){
                break;
            }
            System.out.println("开始处理注册事件");
            task.run();
        }
    }

    private void processSelectedKeys() throws IOException {
        System.out.println("开始处理I/O事件");
        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            iterator.remove();
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
    }

    @Override
    public void run(){
        while (true) {
            try {
                //等待任务
                select();
                //I/O任务来了先处理I/O任务
                processSelectedKeys();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                //最后处理队列任务。第一遍走过来的时候会先处理队列任务
                runAllTasks();
            }
        }
    }
}
