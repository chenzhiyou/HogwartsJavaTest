package com.hogwarts.ch12_interface;

public interface Animal {
    public default void run(){};
    public static void jump(){};
//    jdk1.9开始有的private方法
//    private void walk(){}
}
