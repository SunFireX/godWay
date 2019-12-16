package com.dyt.swm.godway.test.ThreadTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/9/10 11:17
 */
public class LockTest implements Runnable{
    static  ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        AtomicInteger  integer = new AtomicInteger();

        System.out.println("1111111111111111");
        new Thread(lockTest).start();
        System.out.println("222222222222222");
        new Thread(lockTest).start();
        System.out.println("33333333333333");
        new Thread(lockTest).start();
        System.out.println("444444444444444");
    }


    @Override
    public void run() {
        readWriteLock.readLock().lock();
        try {
            System.out.println("线程开始!!!!!");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束!!!!!");
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    static class MyThread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread.run()");
        }
    }

    static class MyThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread2.run()");
        }
    }

}
