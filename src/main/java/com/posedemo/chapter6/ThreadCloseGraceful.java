package com.posedemo.chapter6;

/**
 * 优雅的结束线程
 */
public class ThreadCloseGraceful {

    private  static class Worker extends  Thread {
        private  volatile  boolean start = true;

        @Override
        public void run() {
            super.run();
        }

        public void shutdown(){
            this.start = false;
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
        worker.shutdown();
    }

}
