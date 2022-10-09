package com.threadPro;

// step1： 继承自Thread类
class MyThread extends Thread{
    @Override
    public void run(){
        // 线程的执行体
        for (int i = 0; i< 10; i++){
            System.out.println("新开的线程： "+ i);
        }
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        // step2： 创建子类对象
        MyThread myThread = new MyThread();
        // step3：调用start()方法
        myThread.start();// 相当于开启一个新的线程，这个新的线程跟main线程是平级的
        myThread.run();// 这样写，是普通方法的调用
        for (int i = 0; i< 10; i++){
            System.out.println("主线程： "+ i);
        }
    }
}
