package com.study.lock;

/**
 * @author: guo
 * 17-11-6 下午3:20
 */
public class ObjectWait {

	private volatile static boolean lock;

	public static void main(String[] args) throws InterruptedException {
		final Object object = new Object();

		Thread thread1 = new Thread(() -> {
			System.out.println("等待被通知！");
			try {
				synchronized (object){
					while(!lock){
						object.wait();
					}
				}
			}catch (InterruptedException e){
				throw new RuntimeException(e);
			}
			System.out.println("已被通知");
		});

		Thread thread2 = new Thread(() -> {
			System.out.println("马上开始通知！");
			synchronized (object){
				object.notify();
				lock=true;
			}
			System.out.println("已经通知");
		});

		thread1.start();
		thread2.start();
		Thread.sleep(10000);
	}
}
