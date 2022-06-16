package com.hogwarts.junit5Basics.ch05_Junit5extend;

import org.junit.jupiter.api.*;

public class BaseATest {

    @BeforeAll
    static void beforeAAll(){
        System.out.println("BaseATest --- beforeAAll ");
    }

    @AfterAll
    static void afterAAll(){
        System.out.println("BaseATest --- afterAAll ");
    }

    @BeforeEach
    void beforeAEach(){
        System.out.println("BaseATest --- beforeAEach ");
    }

    @AfterEach
    void AfterAEach(){
        System.out.println("BaseATest --- AfterAEach ");
    }

    @Test
    void hogwarts1(){
        System.out.println("BaseATest --- hogwarts1测试用例");
    }

    @Test
    void hogwarts2(){
        System.out.println("BaseATest --- hogwarts2测试用例");
    }

    @Test
    void hogwarts5(){
        System.out.println("BaseATest --- hogwarts5测试用例");
    }
}
