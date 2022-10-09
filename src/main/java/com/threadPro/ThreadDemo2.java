package com.threadPro;

// step1： 实现Runnable接口
class MyRunnable implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        // 线程的执行体
        for (int i = 0; i< 10; i++){
            System.out.println("新开的线程： "+ i);
            System.out.println(Thread.currentThread().getName()+ "卖了一张票， 剩下： "+ ticket--);
        }
    }
}

/**
 * 继承Thread和实现Runnable的区别
 *      如果一个类继承Thread，则不适合资源共享。但是如果实现了Runnable接口的话，则很容易的实现资源共享；
 *      总结：实现Runnable接口比继承Thread类所具有的优势：
 *          1、适合多个相同的程序代码的线程去共享同一个资源
 *          2、可以避免Java中的单继承的局限性
 *          3、增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立
 * 线程的常用方法：
 *      setPriority()设置线程的有限级别
 *          调整线程优先级：Java线程有优先级，优先级高的线程会获得较多的运行机会，优先级：只能反应线程的中或者紧急成都，不能解决是否一定先执行
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        //step2:创建实现类的对象
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable, "窗口1");
        // step3: 启动一个线程
        thread1.start();
        Thread thread2 = new Thread(myRunnable, "窗口2");
        // step3: 启动一个线程
        thread2.start();
        Thread thread3 = new Thread(myRunnable, "窗口3");
        // step3: 启动一个线程
        thread3.start();

        for (int i = 0; i< 10; i++){
            System.out.println("主线程： "+ i);
        }
    }
}
