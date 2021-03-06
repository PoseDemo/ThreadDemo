package com.posedemo.chapter7;

public class SynchronizedRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 500;

    private final Object MONITOR = new Object();

    @Override
    public synchronized void run() {
        while (true) {
            if (index <= MAX) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
            }
        }
    }
}
