package com.study.lock.demo1;

/**
 * 利用锁线程间通信
 * @author: guo
 * 17-12-1 下午3:31
 */
public class TreadCall {

	private static boolean lock = false;
	private static Object object = new Object();
	/**
	 * Jack
	 * 1.我已进入茅厕
	 * 2.擦，太臭了，我还是撤！
	 * 3.兄弟说的对，我还是进去吧。
	 * 4.拉完了，真舒服。
	 */
	static class Jack implements Runnable{
		@Override
		public void run() {
			synchronized (object) {
				System.out.println(Thread.currentThread().getName() + ": 我已进入茅厕");
				System.out.println(Thread.currentThread().getName() + ": 擦，太臭了，我还是撤！");
				lock = true;
				while (lock){
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ": 等待jone喊我进去");
				}
			}
			System.out.println(Thread.currentThread().getName() + ": 兄弟说的对，我还是进去吧。");
			System.out.println(Thread.currentThread().getName() + ": 拉完了，真舒服。");
		}
	}

	/**
	 * Jone
	 * 1.直奔茅厕，兄弟，你还是进来吧，小心憋坏了！
	 * 2.哗啦啦....
	 * 3.拉完了,真舒服。
	 */
	static class Jone implements Runnable{
		@Override
		public void run() {
			synchronized (object) {
				System.out.println(Thread.currentThread().getName() + ": 直奔茅厕，兄弟，你还是进来吧，小心憋坏了！");
				lock = false;
			}
			System.out.println(Thread.currentThread().getName() + ": 哗啦啦....");
			System.out.println(Thread.currentThread().getName() + ": 拉完了,真舒服。");
		}
	}

	public static void main(String[] args) {
		Thread jack = new Thread(new Jack(), "jack");
		Thread jone = new Thread(new Jone(), "jone");

		jack.start();
		jone.start();
	}

}
