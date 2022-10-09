package com.threadPro;

class JoinThread extends Thread{
    public JoinThread(String name){
        super(name);
    }
    public void run(){
        for (int i = 0; i< 10; i++){
            System.out.println(Thread.currentThread().getName()+"打印------------>"+ i);
        }
    }
}

/**
 * join方法：主线程的执行会被打断，直到新加入的线程执行完毕，主线程才继续
 * 为什么要用join()方法：
 *      在很多情况下，主线程生成并启动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，需要
 *      用到子线程的处理结果，也就是主线程需要等待子线程执行完成后再结束，这个时候就需要用到join方法了
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始执行----------------------->");
        JoinThread joinThread = new JoinThread("新加入的线程");
        joinThread.start();
        joinThread.join();
        System.out.println("主线程结束执行----------------------->");
    }
}
