package com.study.lock.demo2;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: guo
 * 17-12-15 下午1:57
 */
public class LockDemo2 {

	private ArrayList<Integer> arrayList = new ArrayList<>();
	private Lock lock = new ReentrantLock();

	public static void main(String[] args) {

		LockDemo2 lockDemo2 = new LockDemo2();

		new Thread(){
			@Override
			public void run() {
				lockDemo2.insert(Thread.currentThread());
			}
		}.start();

		new Thread(){
			@Override
			public void run() {
				lockDemo2.insert(Thread.currentThread());
			}
		}.start();
	}

	public void insert(Thread thread){
		if(lock.tryLock()){
			//睡1s，目的是让线程2获取锁失败
			System.out.println(thread.getName() + "获取锁成功");
			try {
				Thread.sleep(1000);
				for (int i = 0; i < 5; i++) {
					arrayList.add(i);
				}
			}catch (Exception e){

			}finally {
				lock.unlock();
				System.out.println(thread.getName() + "释放了锁");
			}
		}else{
			System.out.println(thread.getName() + "获取锁失败");
		}
	}

}
