package com.study.lock.demo2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: guo
 * 17-12-15 下午2:07
 */
public class ReadWriteLockDemo1 {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String[] args) {

		ReadWriteLockDemo1 demo1 = new ReadWriteLockDemo1();

		new Thread(){
			@Override
			public void run() {
				demo1.test(Thread.currentThread());
			}
		}.start();

		new Thread(){
			@Override
			public void run() {
				demo1.test(Thread.currentThread());
			}
		}.start();
	}

	public void test(Thread thread){
		lock.readLock().lock();
		try {
			long time = System.currentTimeMillis();
			while (System.currentTimeMillis() - time <= 1) {
				System.out.println(thread.getName() + "读取中");
			}
			System.out.println(thread.getName() + "读取完毕");
		}catch (Exception e){

		}finally {
			lock.readLock().unlock();
		}
	}
}

