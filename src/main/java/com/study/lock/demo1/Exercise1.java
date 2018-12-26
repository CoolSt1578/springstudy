package com.study.lock.demo1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 输出不是1,2,3,4,5,6,7,8,9,10
 * @author: guo
 * 17-12-1 下午3:21
 */
public class Exercise1 {

	private static int count = 0;

	private static ReentrantLock object = new ReentrantLock();

	static class Task implements Runnable{
		@Override
		public void run() {
			try {
				Thread.sleep(100);
//				object.lock();
				System.out.println("当前数字: " + ++count);
//				object.unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}


	public static void main(String[] args) {
		for(int i=0; i<10; i++){
			Thread thread = new Thread(new Task());
			thread.start();
		}
	}
}
