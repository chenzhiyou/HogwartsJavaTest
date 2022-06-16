package com.hogwarts.junit5Basics.ch03_Junit5structure;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaseTest {
    // 该方法必须是静态方法

    /**
     * all和each的区别
     * 1、all在一个测试类中，只执行一次，打算each是有多少个方法就执行几次
     * 2、all注解修饰static方法，不能修饰普通方法，each可以修饰普通方法
     * 3、如果BeforeALl和BeforeEach同时存在，优先执行BeforeALl，最后执行AfterAll
     */
    @BeforeAll
    static void setUpAll(){
        System.out.println("CaseTest所有测试用例执行前的前置操作");

    }

    @BeforeEach
    void setUp(){
        System.out.println("CaseTest每条测试用例执行前的前置操作");
    }

    @Test
    @DisplayName("CaseTest的第一条用例")
    void hogwarts(){
        System.out.println("caseTest第一条测试用例");
        assertEquals(2, 1+1);
    }

    @Test
    @DisplayName("CaseTest的第二条用例")
    void hogwarts1(){
        System.out.println("caseTest第二条测试用例");
        assertEquals(2, 1+1);
    }

    @AfterEach
    void tearDown(){
        System.out.println("CaseTest每条测试用例执行后的前置操作");

    }

    @AfterAll
    static void teardownAll(){
        System.out.println("CaseTest所有测试用例执行后的前置操作");

    }
}
