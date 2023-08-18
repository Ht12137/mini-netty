package com.panika.test;


import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class SingleThreadEventExecutor implements Executor {

    private volatile boolean isSingle = false;

    private RejectedExecutionHandler rejectedExecutionHandler;

    protected Queue<Runnable> tasksQueue;

    protected Thread thread;

    //初始化的时候，1.构建线程池的属性，如队列，拒绝策略。2.构建当前线程的Selector
    public SingleThreadEventExecutor() {
        this.tasksQueue = new LinkedBlockingQueue<>(Integer.MAX_VALUE);
        this.rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
    }

    protected final void reject(Runnable task) {
//        rejectedExecutionHandler.rejectedExecution(task, this);
    }

    protected boolean inEventLoop(Thread thread){
        return this.thread == thread;
    }

    protected boolean hasTasks(){
        return this.tasksQueue.isEmpty();
    }


    @Override
    public void execute(Runnable task) {

        //此时仍然是主线程。先把任务放入队列，后续处理
        addTask(task);
        System.out.println("任务添加完成");
        startThread(task);
    }

    protected final void addTask(Runnable task){
        this.tasksQueue.add(task);
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


    protected abstract void run();


}
