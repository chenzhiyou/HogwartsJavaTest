package com.hogwarts.ch12_interface;

public interface InterfaceDemo {
    public static final int age = 20;
    public abstract void eat();
    public default void run(){
        System.out.println("这是一个default方法");
    }

    public static void jump(){
        System.out.println("这是一个静态方法");
    }

    default void walk(){
        System.out.println("这是一个私有方法");
    }
}
