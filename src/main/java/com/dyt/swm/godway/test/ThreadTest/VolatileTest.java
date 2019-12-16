package com.dyt.swm.godway.test.ThreadTest;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/9/16 16:30
 */
public class VolatileTest {

    private static boolean isOver = false;
//    private static volatile boolean isOver = false;
    private static int a = 1;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                    a++;
                }

            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }

}
