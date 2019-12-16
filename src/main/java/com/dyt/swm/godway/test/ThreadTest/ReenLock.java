package com.dyt.swm.godway.test.ThreadTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/9/10 15:11
 */
public class ReenLock {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    Lock lock = new ReentrantLock();    //注意这个地方
    public static void main(String[] args)  {

        final ReenLock test = new ReenLock();

        new Thread(){

            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
        new Thread(){

            public void run() {

                test.insert(Thread.currentThread());

            };

        }.start();

    }



    public void insert(Thread thread) {

        lock.lock();

        try {

            System.out.println(thread.getName()+"得到了锁");

            for(int i=0;i<5;i++) {
                TimeUnit.SECONDS.sleep(3);
                arrayList.add(i);

            }

        } catch (Exception e) {

            // TODO: handle exception

        }finally {

            System.out.println(thread.getName()+"释放了锁");

            lock.unlock();

        }

    }

}
