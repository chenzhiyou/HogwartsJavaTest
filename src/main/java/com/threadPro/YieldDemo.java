package com.threadPro;

import org.mozilla.javascript.ast.Yield;

class Task1 implements Runnable{

    @Override
    public void run() {
        for (int i =0; i<200; i++){
            System.out.println("A: "+ i);
        }
    }
}

class Task2 implements Runnable{

    @Override
    public void run() {
        for (int i =0; i<200; i++){
            System.out.println("B: "+ i);
            // 让步
            Thread.yield();
        }
    }
}

/**
 * sleep和yield的区别
 *      sleep使当前线程进入停滞状态，所以执行sleep的线程在指定的时间内肯定不会被执行
 *      yield只是使当前线程重新回到可执行状态，所以执行yield的线程有可能在进入到可执行状态后马上又被执行
 */
public class YieldDemo {
    public static void main(String[] args) {
        // 匿名对象，这个方法只需要使用1次
        new Thread(new Task1()).start();
        new Thread(new Task2()).start();
    }
}
