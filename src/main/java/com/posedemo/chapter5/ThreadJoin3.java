package com.posedemo.chapter5;

import java.awt.*;

public class ThreadJoin3 {
    public static void main(String[] args) throws InterruptedException {
        long startTimeStamp = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 10000L));
        Thread t2 = new Thread(new CaptureRunnable("M2", 30000L));
        Thread t3 = new Thread(new CaptureRunnable("M3", 15000L));
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long endTimeStamp = System.currentTimeMillis();
        System.out.printf("Save data begin timestamp is:%s, end timestamp is :%s\n", startTimeStamp, endTimeStamp);
    }
}

class CaptureRunnable implements Runnable {

    private String machineName;
    private long spendTime;

    public CaptureRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.printf(machineName + "completed data capture at timestamp [%s] and successfully.\n", System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        return machineName + " finish.";
    }

}