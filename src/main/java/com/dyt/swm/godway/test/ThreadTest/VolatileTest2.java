package com.dyt.swm.godway.test.ThreadTest;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/9/16 16:50
 */
public class VolatileTest2 {
    private static int a = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    a++;
                }
            }).start();
        }

        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a);

    }



}
