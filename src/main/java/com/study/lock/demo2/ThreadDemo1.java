package com.study.lock.demo2;

import java.io.IOException;

/**
 * @author: guo
 * 17-12-15 下午3:52
 */
public class ThreadDemo1 {

	private static Object lock = new Object();

	public static void main(String[] args) throws IOException {
		System.out.println("进入线程"+Thread.currentThread().getName());
		ThreadDemo1 test = new ThreadDemo1();
		MyThread thread1 = test.new MyThread();
		thread1.start();
		try {
			System.out.println("线程"+Thread.currentThread().getName()+"等待");
			synchronized (lock) {
				thread1.join();
			}
			System.out.println("线程"+Thread.currentThread().getName()+"继续执行");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class MyThread extends Thread{
		@Override
		public void run() {
			synchronized (lock) {
				System.out.println("进入线程" + Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
			}
		}
	}
}