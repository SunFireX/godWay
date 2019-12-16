package com.dyt.swm.godway.test.ThreadTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/9/24 10:00
 */
public class MyRecursiveTask extends RecursiveTask<Integer> {

    private int begin;
    private int end;
    public MyRecursiveTask(int begin, int end) {
        super();
        this.begin = begin;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        if ((end - begin) != 0) {
            int min = (begin + end) / 2;
            MyRecursiveTask myRecursiveTaskLeft = new MyRecursiveTask(begin, min);
            MyRecursiveTask myRecursiveTaskRight = new MyRecursiveTask(min + 1, end);
            this.invokeAll(myRecursiveTaskLeft, myRecursiveTaskRight);
            int left = myRecursiveTaskLeft.join();
            int right = myRecursiveTaskRight.join();
            return left + right;
        } else {
            int sum = 0;
            for (int j = 0; j <= 100; j++) {
                sum+=j;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i <= 86400; i++) {
            for (int j = 0; j <= 1000000; j++) {
                sum += j;
            }
        }
        System.out.println("结果值：" + sum);
        System.out.println("消耗时间：" + (System.currentTimeMillis() - begin));*/

        long begin2 = System.currentTimeMillis();
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(0, 6);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(myRecursiveTask);
        System.out.println("结果值：" + myRecursiveTask.get());
        pool.shutdown();
        System.out.println("消耗时间：" + (System.currentTimeMillis() - begin2));
    }

}
