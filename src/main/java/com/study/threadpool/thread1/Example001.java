package com.study.threadpool.thread1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example001 {

    public static void main(String[] args) {

        //============= CachedThreadPool =============
        /**
         * newCachedThreadPool
         * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收的空闲线程，则新建线程
         * 线程池为无限大，当执行第二个任务时第一个任务已完成，会复用执行第一个任务的线程，而不用每次新建线程
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0; i<10; i++){
            final int index = 0;
            try{
                Thread.sleep(index * 1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            cachedThreadPool.execute(() -> System.out.println(index));
        }

        //============= FixedThreadPool =============
        /**
         * newFixedThreadPool
         * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
         * 因为线程池的大小是3，每个任务输出index后sleep2秒，所以每2秒打印3个数字
         * 定长线程池的大小最好根据系统资源进行设置，如Runtime.getRuntime().availableProcessors()。可参考PreloadDataCache
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for(int i=0; i<10; i++){
            final int index = i;

            fixedThreadPool.execute(() ->{
                try {
                    System.out.println(index);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        //============= ScheduledThreadPool =============
        /**
         * newScheduledThreaPool
         * 创建一个定长线程池，支持定时及周期性任务执行
         * 表示延迟3s执行
         */
        ScheduledExecutorService scheduledTreadPool = Executors.newScheduledThreadPool(5);
        scheduledTreadPool.schedule(() -> System.out.println("delay 3 seconds"), 3, TimeUnit.SECONDS);

        //============= SingleThreadExecutor =============
        /**
         * 创建一个单线程化的线程池，它会只用唯一的工作线程来工作，保证所有任务按照指定顺序(FIFO,LIFO,优先级)执行
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for(int i=0; i<10; i++){
            final int index = i;
            singleThreadExecutor.execute(() -> {
                try {
                    System.out.println(index);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
