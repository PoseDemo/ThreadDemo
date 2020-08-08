package com.posedemo.chapter6;


/**
 * join 中断
 */
public class ThreadInterrupt4 {

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                }
            }
        };
        t.start();
        Thread main = Thread.currentThread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                main.interrupt();
                System.out.println("interrupt");
            }
        };
        t2.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
