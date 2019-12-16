package com.dyt.swm.godway.test.ThreadTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/9/10 9:12
 */
public class ThreadTest {

    public static void main(String[] args) {
        Map hashMap =  new HashMap<>();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        //threadSort();
        new MyThread1().run();
        System.out.println("myThread>>>>>");

    }

    private static void threadSort() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }


    static class MyThread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread.run()");
        }
    }




}
