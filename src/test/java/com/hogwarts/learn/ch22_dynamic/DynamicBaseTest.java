package com.hogwarts.learn.ch22_dynamic;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicBaseTest {

    @Test
    void testAdd(){
        assertEquals(5, 3+2);
    }

    @Test
    void testDevide(){
        assertEquals(5, 25/5);
    }

    @TestFactory
    @DisplayName("动态测试用例")
    Collection<DynamicNode> dynamicForCollection(){
        DynamicTest dynamicTest = DynamicTest.dynamicTest("加法动态测试用例", () -> {
            System.out.println("这是一个加法测试用例");
            assertEquals(5, 3 + 2);
        });
        DynamicTest dynamicTest2 = DynamicTest.dynamicTest("除法动态测试用例", () -> {
            assertEquals(5, 25/5);
        });
       return Arrays.asList(dynamicTest, dynamicTest2);
    }
}
