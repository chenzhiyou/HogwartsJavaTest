package com.threadPro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThreadPool implements Runnable{

    @Override
    public void run() {
        System.out.println("我要一个教练");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("教练来了: " + Thread.currentThread().getName());
        System.out.println("交完后，教练回到了游泳池");
    }
}
/**
 * 使用线程池的优点：
 *      1、降低资源消耗，减少创建和销毁线程的次数，每个工作线程池都可以被重复利用，可执行多个任务
 *      2、提高响应速度，当任务到达时，任务可以不需要等到线程创建就能立即执行
 *      3、提高线程的可管理性，可以根据系统的承受能力，调整线程池中工作线程的数目，防止因为消耗过多的内存，而把服务器累趴下（
 *      每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机）
 * 线程池的使用
 *      newFixedThreadPool 创建一个固定长度的线程池，当到达线程最大数量时，线程池的规模将不在变化
 *      newCachedThreadPool 创建一个可缓存的线程池，如果当前线程池的规模超出了处理需求，将回收空的线程，当需求增加时，会增加线程数量，线程池规模无限制
 *      newSingleThreadPoolExecutor 创建一个单线程的Executor，确保任务队列，串行执行
 *      newScheduledThreadPool 创建一个固定长度的线程池，而且以延迟或者定时的方式来执行，类似Timer
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建线程池对象
//        ExecutorService pool = Executors.newFixedThreadPool(3);
        // 创建一个可缓存的线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        // 创建Runnable接口子类对象（task）
        MyThreadPool myThreadPool = new MyThreadPool();
        //提交Runnable接口子类对象(task task)
        pool.submit(myThreadPool);
        pool.submit(myThreadPool);
        pool.submit(myThreadPool);
        pool.submit(myThreadPool);
    }
}
