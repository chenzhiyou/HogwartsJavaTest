package com.hogwarts.junit5Basics.ch19_dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DynamicOrderTest {
    @TestFactory
    Collection<DynamicTest> dynamicTestCollection(){
        List<DynamicTest> dynamicTests = new ArrayList<>();
        DynamicTest dynamicTest1 = DynamicTest.dynamicTest("第一个动态测试", () -> {
            System.out.println("第一个动态测试赛");
        });

        DynamicTest dynamicTest2 = DynamicTest.dynamicTest("第二个动态测试", () -> {
            System.out.println("第二个动态测试赛");
        });

        DynamicTest dynamicTest3 = DynamicTest.dynamicTest("第三个动态测试", () -> {
            System.out.println("第三个动态测试赛");
        });
        dynamicTests.add(dynamicTest1);
        dynamicTests.add(dynamicTest2);
        dynamicTests.add(dynamicTest3);
        sortDy(dynamicTests);
        return dynamicTests;
    }

    static void sortDy(List<DynamicTest> dynamicTests){
        dynamicTests.sort((DynamicTest t1, DynamicTest t2) -> t2.getDisplayName().compareTo(t1.getDisplayName()));
    }
}
