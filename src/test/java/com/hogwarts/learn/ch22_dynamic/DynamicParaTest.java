package com.hogwarts.learn.ch22_dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DynamicParaTest {

    @TestFactory
    Collection<DynamicTest> dynamicCollectionTest(){
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        Arrays.asList("192.168.0.1", "192.168.0.2", "192.168.0.3").forEach(
                s -> {
                    DynamicTest dynamicTest1 = DynamicTest.dynamicTest("1、集合参数化" + s, () -> {
                        System.out.println("集合参数化： " + s);
                    });
                    DynamicTest dynamicTest2 =DynamicTest.dynamicTest("IP参数化: "+ s, ()->{
                        System.out.println("IP参数化: "+ s);
                    });
                    dynamicTests.add(dynamicTest1);
                    dynamicTests.add(dynamicTest2);
                }
        );
        return dynamicTests;
    }
}
