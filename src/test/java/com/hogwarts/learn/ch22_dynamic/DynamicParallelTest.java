package com.hogwarts.learn.ch22_dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Arrays;
import java.util.Collection;

public class DynamicParallelTest {

    @TestFactory
    @Execution(ExecutionMode.CONCURRENT)
    Collection<DynamicTest> parallelTest(){
        DynamicTest dynamicTest1 = DynamicTest.dynamicTest("1st parallel", ()->{
            System.out.println(Thread.currentThread().getName()+ "----1st parallel");
        });
        DynamicTest dynamicTest2 = DynamicTest.dynamicTest("2st parallel", ()->{
            System.out.println(Thread.currentThread().getName()+ "----2st parallel");
        });
        DynamicTest dynamicTest3 = DynamicTest.dynamicTest("3st parallel", ()->{
            System.out.println(Thread.currentThread().getName()+ "----3st parallel");
        });
        return Arrays.asList(dynamicTest1, dynamicTest2, dynamicTest3);
    }

    @TestFactory
    @Execution(ExecutionMode.SAME_THREAD)
    Collection<DynamicTest> parallel2Test(){
        DynamicTest dynamicTest1 = DynamicTest.dynamicTest("1st parallel", ()->{
            System.out.println(Thread.currentThread().getName()+ "----1st parallel");
        });
        DynamicTest dynamicTest2 = DynamicTest.dynamicTest("2st parallel", ()->{
            System.out.println(Thread.currentThread().getName()+ "----2st parallel");
        });
        DynamicTest dynamicTest3 = DynamicTest.dynamicTest("3st parallel", ()->{
            System.out.println(Thread.currentThread().getName()+ "----3st parallel");
        });
        return Arrays.asList(dynamicTest1, dynamicTest2, dynamicTest3);
    }
}
