package com.hogwarts.junit5Basics.ch17_parallel;

import org.junit.jupiter.api.Test;

public class Parallel3_Test {

    @Test
    void test1(){
        System.out.println(Thread.currentThread().getName()+ "=>Parallel3_Test--test1");
    }
    @Test
    void test2(){
        System.out.println(Thread.currentThread().getName()+ "=>Parallel3_Test--test2");
    }
    @Test
    void test3(){
        System.out.println(Thread.currentThread().getName()+ "=>Parallel3_Test--test3");
    }
}
