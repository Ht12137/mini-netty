package com.panika.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class SingleThreadEventExecutor implements Executor {

    volatile boolean isSingle = false;

    private Queue<Runnable> tasksQueue;

    private Selector selector ;

    Thread thread;

    //初始化的时候，1.构建线程池的属性，如队列，拒绝策略。2.构建当前线程的Selector
    public SingleThreadEventExecutor() {
        try {
            this.selector = Selector.open();
            this.tasksQueue = new LinkedBlockingQueue<>(Integer.MAX_VALUE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean inEventLoop(Thread thread){
        return this.thread == thread;
    }

    private void register0(SocketChannel socketChannel){
        try {
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //注册socketChannel到当前的selector上
    public void register(SocketChannel socketChannel){
        //先判断当前线程是否是执行器线程，如果不是，说明是主线程，那么就还没被构造。
        if(inEventLoop(Thread.currentThread())){
            register0(socketChannel);
        }else {
            //否则是第一次注册，就先构造线程即可。
            execute(()->{
                register0(socketChannel);
                System.out.println("executor执行完成");
            });
        }
    }


    @Override
    public void execute(Runnable task) {

        //此时仍然是主线程。先把任务放入队列，后续处理
        tasksQueue.add(task);
        System.out.println("任务添加完成");
        startThread(task);
    }

    private void startThread(Runnable task) {
        if (isSingle) {
            return;
        }
        isSingle = true;
        System.out.println("新线程任务成功创建");
        //这是个异步线程,单线程执行器的核心
        new Thread(()->{
            thread = Thread.currentThread();
            SingleThreadEventExecutor.this.run();
            System.out.println("新线程任务跑完了");
        }).start();

    }
    //循环阻塞，如果有事件发生，或者队列有东西，就放行
    private void select() throws IOException {
        while (true){
            //阻塞等待事件，如果3s都没有事件过来，可能是没有初始化。
            int select = selector.select(3000);
            if(select != 0 || !tasksQueue.isEmpty()){
                if(select != 0){
                    System.out.println("I/O任务来了");
                }else if(!tasksQueue.isEmpty()){
                    System.out.println("队列中有任务");
                }else if(select != 0 && !tasksQueue.isEmpty()){
                    System.out.println("均有");
                }
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
