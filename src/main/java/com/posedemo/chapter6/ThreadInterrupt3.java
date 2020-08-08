package com.posedemo.chapter6;

public class ThreadInterrupt3 {

    private static Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {

        //静态 interrupted() 方法
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println(">>>" + Thread.interrupted());
                        }
                    }
                }
            }
        };

    }


}
