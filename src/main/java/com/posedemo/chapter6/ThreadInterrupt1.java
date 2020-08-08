package com.posedemo.chapter6;

/**
 * sleep 中断
 */
public class ThreadInterrupt1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("收到打断信号.");
                        System.out.println(">>>" + this.isInterrupted());
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        Thread.sleep(100);
        System.out.println(t.isInterrupted());
        t.interrupt();   // 实例方法
        System.out.println(t.isInterrupted());
//        t.stop();
    }

}
