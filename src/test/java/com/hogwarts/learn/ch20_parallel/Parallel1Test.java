package com.hogwarts.learn.ch20_parallel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
public class Parallel1Test {

    @Test
    void test1(){
        System.out.println(Thread.currentThread().getName() + "Parallel1Test---test1");
    }
    @Test
    void test2(){
        System.out.println(Thread.currentThread().getName() + "Parallel1Test---test2");
    }
    @Test
    void test3(){
        System.out.println(Thread.currentThread().getName() + "Parallel1Test---test3");
    }
}
