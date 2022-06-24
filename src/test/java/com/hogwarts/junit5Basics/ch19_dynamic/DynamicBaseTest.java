package com.hogwarts.junit5Basics.ch19_dynamic;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicBaseTest {

    @Test
    void testAdd(){
        assertEquals(5, 2+3);
    }

    @TestFactory
    @DisplayName("动态测试用例")
    Collection<DynamicNode> dynamicForCollection(){
        DynamicTest dynamicTest = DynamicTest.dynamicTest("加法动态测试用例", () -> {
            assertEquals(5, 2 + 3);
        });

        DynamicTest dynamicTest2 = DynamicTest.dynamicTest("除法动态测试用例", () -> {
            assertEquals(5,  25/5);
        });
        return Arrays.asList(dynamicTest, dynamicTest2);
    }
}
