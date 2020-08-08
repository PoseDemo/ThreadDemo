package com.posedemo.chapter6;

/**
 * 线程block 没有机会获取判断信息结束时
 * 强制结束线程
 */
public class ThreadCloseForce {

    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(() -> {
//            while (true) {
// 
//            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        service.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
