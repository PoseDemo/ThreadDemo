package com.posedemo.chapter6;

/**
 * wait 中断
 */
public class ThreadInterrupt2 {

    private static Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println(">>>" + this.isInterrupted());
                        }
                    }
                }
            }
        };
        t.start();
        Thread.sleep(100);
        System.out.println(t.isInterrupted());
        t.interrupt(); // 实例方法
        System.out.println(t.isInterrupted());

//        t.stop();

    }
}
