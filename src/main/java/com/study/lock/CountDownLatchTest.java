package com.study.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author: guo
 * 17-11-6 下午5:02
 */
public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch countDownLatch = new CountDownLatch(10);

		for(int i=0; i<10; i++){
			final int number = i + 1;
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try{
						Thread.sleep(1000);
					}catch (InterruptedException e){
						System.out.println("error");
					}
					System.out.println("执行任务[" + number + "]");
					countDownLatch.countDown();
					System.out.println("完成任务[" + number + "]");
				}
			};
			Thread thread = new Thread(runnable);
			thread.start();
		}

		System.out.println("主线程开始...");
		countDownLatch.await();
		System.out.println("主线程执行完毕...");
	}
}
