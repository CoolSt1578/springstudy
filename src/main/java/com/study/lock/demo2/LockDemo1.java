package com.study.lock.demo2;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: guo
 * 17-12-15 上午10:56
 */
public class LockDemo1 {

	private ArrayList<Integer> list = new ArrayList<>();
	Lock lock = new ReentrantLock();

	public static void main(String[] args) {

		final LockDemo1 demo1 = new LockDemo1();


		Thread thread1 = new Thread("0"){
			@Override
			public void run(){
				demo1.insert(Thread.currentThread());
			}
		};
		thread1.start();

		Thread thread2 = new Thread("1"){
			@Override
			public void run() {
				demo1.insert(Thread.currentThread());
			}
		};
		thread2.start();
	}

	public void insert(Thread thread){
//		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			System.out.println(thread.getName()+"得到锁");
			for (int i = 0; i < 5; i++) {
				list.add(i);
			}
		}catch (Exception e){

		}finally {
			System.out.println(thread.getName() + "释放了锁");
			lock.unlock();
		}
	}
}
