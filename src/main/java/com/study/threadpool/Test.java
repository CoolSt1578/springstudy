package com.study.threadpool;

import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future future = executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
        //如果任务结束执行则返回 null
        System.out.println(future.get());


        Future future1 = executorService.submit(new Callable<Object>() {
            public Object call() {
                System.out.println("Asynchronous task");
                return "1";
            }
        });
        //如果任务结束执行则返回 null
        System.out.println(future1.get());

        executorService.shutdown();
    }
}
