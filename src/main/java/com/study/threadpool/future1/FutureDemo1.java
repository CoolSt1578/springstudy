package com.study.threadpool.future1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo1 {

    static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程并提交线程，同时获取一个future对象
        Thread subThread = new Thread(new SubThread());
        Future future = executorService.submit(subThread);

        //主线程处理其他工作，子线程异步执行
        mainWork();
        //阻塞主线程，等待子线程执行
        future.get();
        System.out.println("All Thread is end");
        //关闭线程池
        executorService.shutdown();
    }

    private static void mainWork() {
        System.out.println("Main Thread is starting");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread is end");
    }

    private static class SubThread implements Runnable{

        @Override
        public void run() {
            System.out.println("Sub Thread is starting");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sub Thread is end");
        }
    }
}
