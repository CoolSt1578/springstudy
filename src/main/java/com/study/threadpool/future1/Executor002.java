package com.study.threadpool.future1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by guodd on 2018/8/3.
 */
public class Executor002 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        Callable<Integer> callableTask = () -> {
            Thread.sleep(2000);
            return 2;
        };

        Future<Integer> future = scheduledExecutorService.schedule(callableTask, 2, TimeUnit.SECONDS);

        int result = 0;

        if(future.isDone()) {
            result = future.get();
        }
//        result = future.get();
        System.out.println(result);

        /**
         * 启动后，等待3000ms执行第一次，然后每隔2000ms执行一次
         * 优先保证任务执行的频率
         */
//        scheduledExecutorService.scheduleAtFixedRate(
//                () -> System.out.println("Fixed Rate Scheduled"), 3000, 2000, TimeUnit.MILLISECONDS)
//
        /**
         * 启动后，等待3000ms执行第一次，然后在每次执行外后，等待2000ms执行下一次
         * 每次执行的间隔时间都是2000ms
         */
//        scheduledExecutorService.scheduleWithFixedDelay(
//                () -> System.out.println("Fixed Delay Scheduled"), 3000, 2000, TimeUnit.MILLISECONDS)
//        ;
    }
}
