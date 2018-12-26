package com.study.lock.demo1;


public class TrueEqualsFalse {

    //volatile保证可见性，但不保证原子性 ready == !ready不是一个原子操作
    private volatile static boolean ready;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (ready == !ready) {
                    System.out.println("!=" + ready);
                    System.exit(0);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                ready = !ready;
            }
        });

        t1.start();
        Thread.sleep(100);
        t2.start();
    }

}
