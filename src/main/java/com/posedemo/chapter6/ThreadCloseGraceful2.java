package com.posedemo.chapter6;

/**
 *  优雅的结束线程
 */
public class ThreadCloseGraceful2 {

    private static class Worker extends Thread {

        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }

}
