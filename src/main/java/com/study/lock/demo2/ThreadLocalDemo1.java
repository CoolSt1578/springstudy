package com.study.lock.demo2;

/**
 * ThreadLocal的map对象的key是当前线程，且每个线程都有各自的ThreadLocal，所以主线程的“我不懂”不会到子线程中
 * @author: guo
 * 17-12-15 上午11:09
 */
public class ThreadLocalDemo1 {

	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		threadLocal.set("我不懂");
		MyTest test1 = new MyTest(threadLocal,"线程甲");
		test1.start();
		MyTest test2 = new MyTest(threadLocal,"线程乙");
		test2.start();
		System.out.println(threadLocal.get());
	}
}

class MyTest extends Thread{

	private ThreadLocal threadLocal;

	public MyTest(ThreadLocal threadLocal,String name){
		super(name);
		this.threadLocal = threadLocal;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			if(i==6){
				threadLocal.set("我还是不懂");
			}
			System.out.println(threadLocal.get()+"账户i的值为:"+i);
		}
	}

}
