package com.threadPro;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyList{
    private Lock lock = new ReentrantLock();
    private String[] strArr = {"A", "B", "", "", ""};
    private int index = 2;

    public void add(String str){
        // 加锁
        lock.lock();
        try{
            strArr[index] = str;
            index++;
            System.out.println(Thread.currentThread().getName()+ "添加了" + str);
        }finally {
            // 释放锁，保证锁的释放
            lock.unlock();
        }


    }

    public String[] getStrArr(){
        return strArr;
    }
}
public class MyListLock {
    public static void main(String[] args) throws InterruptedException {
        MyList myList = new MyList();
        // 匿名内部类
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                myList.add("hello");
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                myList.add("world");
            }
        };

        Thread t1 = new Thread(runnable1, "线程A");
        Thread t2 = new Thread(runnable2, "线程B");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        String[] strArr = myList.getStrArr();
        for (String str: strArr){
            System.out.println("数组元素有： "+ str);
        }
    }
}
