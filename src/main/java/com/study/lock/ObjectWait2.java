package com.study.lock;

/**
 * @author: guo
 * 17-11-6 下午4:53
 */
public class ObjectWait2 {

	public static void main(String[] args) throws InterruptedException {

		final Object object1 = new Object();
		final Object object2 = new Object();

		Thread thread1 = new Thread(() -> {
			try{
				System.out.println("object1等待被通知");
				synchronized (object1){
					object1.wait();
				}
				System.out.println("object1已被通知，马上开始通知object2");
				synchronized (object2){
					object2.notify();
				}
				System.out.println("通知object2完毕！");
			}catch (InterruptedException e){
				throw new RuntimeException(e);
			}

		});

		Thread thread2 = new Thread(() -> {
			try {
				System.out.println("开始通知object1");
				synchronized (object1){
					object1.notify();
				}
				System.out.println("已经通知object1，object2等待被通知");
				synchronized (object2){
					object2.wait();
				}
				System.out.println("object2已被通知！");
			}catch (InterruptedException e){
				throw new RuntimeException(e);
			}

		});

		thread1.start();
		Thread.sleep(1000);
		thread2.start();

	}
}
