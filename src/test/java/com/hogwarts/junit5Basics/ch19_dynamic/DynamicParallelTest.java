package com.hogwarts.junit5Basics.ch19_dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
public class DynamicParallelTest {
    @TestFactory
    Collection<DynamicTest> parallelTest(){
        DynamicTest dynamicTest1 = DynamicTest.dynamicTest("1st parall", () -> {
            System.out.println(Thread.currentThread().getName() + "*****************1st parall");
        });
        DynamicTest dynamicTest2 = DynamicTest.dynamicTest("2st parall", () -> {
            System.out.println(Thread.currentThread().getName() + "*****************2st parall");
        });
        DynamicTest dynamicTest3 = DynamicTest.dynamicTest("3st parall", () -> {
            System.out.println(Thread.currentThread().getName() + "*****************3st parall");
        });

        return Arrays.asList(dynamicTest1, dynamicTest2, dynamicTest3);
    }
}
