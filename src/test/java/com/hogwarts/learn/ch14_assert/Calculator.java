package com.hogwarts.learn.ch14_assert;

public class Calculator {
    public static int result = 0;

    public static int add(int x, int y) throws InterruptedException {
        result = x+y;
        Thread.sleep(1000);
        return result;
    }
}
