package com.hogwarts.junit5Basics.ch19_dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DynamicParamTest {

    @TestFactory
    Collection<DynamicTest> dynamicTestCollection(){
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        Arrays.asList("192.168.0.1", "192.168.0.100", "10.47.0.1")
                .forEach(
                        s -> {
                            DynamicTest dynamicTest1 = DynamicTest.dynamicTest("1、集合参数化：-" + s, () -> {
                                System.out.println("1、集合参数化- " + s);
                            });
                            DynamicTest dynamicTest2 = DynamicTest.dynamicTest("2、IP参数化： " + s, () -> {
                                System.out.println("2、IP参数化:-" + s);
                            });
                            dynamicTests.add(dynamicTest1);
                            dynamicTests.add(dynamicTest2);
                        }
                );
        return dynamicTests;
    }
}
