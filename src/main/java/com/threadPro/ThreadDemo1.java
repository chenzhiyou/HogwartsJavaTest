package com.threadPro;

// step1： 继承自Thread类
class MyThread extends Thread{
    @Override
    public void run(){
        // 线程的执行体
        for (int i = 0; i< 50; i++){
            System.out.println(Thread.currentThread().getName()+"==============="+ i);
        }
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        // step2： 创建子类对象
        MyThread myThread1 = new MyThread();
        myThread1.setName("P1线程");
        MyThread myThread2 = new MyThread();
        myThread2.setName("P2线程");
        MyThread myThread3 = new MyThread();
        myThread3.setName("P3线程");
        // step3：调用start()方法
        myThread1.start();// 相当于开启一个新的线程，这个新的线程跟main线程是平级的
//        myThread1.run();// 这样写，是普通方法的调用
        myThread2.start();
        myThread3.start();
        myThread1.setPriority(Thread.MAX_PRIORITY);
        myThread3.setPriority(Thread.MIN_PRIORITY);
//        for (int i = 0; i< 10; i++){
//            System.out.println("主线程： "+ i);
//        }
    }
}
