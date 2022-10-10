package com.threadPro;

/**
 * 线程通信：等待唤醒机制
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        Object lock = new Object(); // 这个是协调者的角色
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("告诉老板，要的早餐产品");
                // 进入等待
                synchronized (lock){
                    // 进入等待
                    try {
                        lock.wait(); // 释放锁，然后进入到等待池中(WAITSET)，程序不会继续往下走，停留在阻塞状态
                        lock.wait(4000);// 设置等待时间，到了时间之后，自动获取到锁，继续执行下去
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("拿到了老板的早餐，开始吃饭");

            }
        }, "顾客线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 等待2秒时间
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("老板给顾客相应的产品");
                // 通知顾客
                synchronized (lock){
                    lock.notify(); // 代码块结束，会释放锁，会到等待池中(WAITSET)被唤醒，重新去竞争锁资源
                    lock.notifyAll();// 通知所有等待的线程
                }
            }
        }, "老板线程").start();
    }
}
