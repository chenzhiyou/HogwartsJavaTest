package com.hogwarts.learn.ch22_dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DynamicOrderTest {

    @TestFactory
    Collection<DynamicTest> dynamicCollectionTest(){
        List<DynamicTest> dynamicTests = new ArrayList<>();
        DynamicTest dynamicTest1 = DynamicTest.dynamicTest("1stDy", ()->{
            System.out.println("1stdy");
        });
        DynamicTest dynamicTest2 = DynamicTest.dynamicTest("2stDy", ()->{
            System.out.println("2stdy");
        });
        DynamicTest dynamicTest3 = DynamicTest.dynamicTest("3stDy", ()->{
            System.out.println("3stdy");
        });
        dynamicTests.add(dynamicTest1);
        dynamicTests.add(dynamicTest2);
        dynamicTests.add(dynamicTest3);
        sortDy(dynamicTests);
        return dynamicTests;
    }

    static void sortDy(List<DynamicTest> dynamicTests){
        dynamicTests.
                sort((DynamicTest t1, DynamicTest t2)-> t2.getDisplayName().compareTo(t1.getDisplayName()));
    }
}
