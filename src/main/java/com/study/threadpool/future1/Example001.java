package com.study.threadpool.future1;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by guodd on 2018/8/3.
 */
public class Example001 {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() ->System.out.println("Single Thread pool test"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> callableTask = () -> {
          Thread.sleep(2000);
          return 2;
        };

        Future<Integer> future = executorService.submit(callableTask);
        executorService.shutdown();
//        executorService.shutdownNow();
        int result = 0;
        Thread.sleep(1000);
        if(future.isDone()){
            try {
                result = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(new Date()+ ":" + result);

        Thread.sleep(1000);
        try {
            result = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(new Date()+ ":" + result);
    }
}
