package com.hogwarts.learn.ch02_structure;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaseTest {

    @BeforeAll
    static void setUpAll(){
        System.out.println("在所有用例前执行一次");
    }

    @BeforeEach
    void setUp(){
        System.out.println("CaseTest每条用例执行之前执行");
    }

    @Test
    @DisplayName("CaseTest的第一条测试用例")
    void hogwarts(){
        System.out.println("CaseTest的第一个测试用例");
        // 测试用例中的断言信息
        assertEquals(2, 1+1);
    }

    @Test
    @DisplayName("CaseTest的第二条测试用例")
    void hogwart2(){
        System.out.println("CaseTest的第二个测试用例");
        // 测试用例中的断言信息
        assertEquals(2, 1+1);
    }

    @AfterEach
    void tearDown(){
        System.out.println("CaseTest每条用例执行之后执行");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("在所有用例后执行一次");
    }
}
