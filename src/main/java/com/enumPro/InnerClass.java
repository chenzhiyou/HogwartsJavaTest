package com.enumPro;

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("run.....");
    }
}

interface USB{
    void work();
}
public class InnerClass {
    public static void main(String[] args) {
        // 匿名对象的写法
//        new Thread(new MyRunnable()).start();
//
//        // 匿名内部类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("run.........");
//            }
//        });

        new USB() {
            @Override
            public void work() {
                System.out.println("匿名内部类的实现。。。。");
            }
        }.work();
    }
}
