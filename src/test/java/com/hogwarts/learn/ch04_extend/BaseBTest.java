package com.hogwarts.learn.ch04_extend;

import org.junit.jupiter.api.*;

/**
 * 用例执行顺序：先执行父类，再执行子类
 * 父类优先级更高，先开始的后结束
 */
public class BaseBTest extends BaseATest{
    @BeforeAll
    static void beforeBAll(){
        System.out.println("BaseBTest --- beforeBAll ");
    }

    @AfterAll
    static void afterBAll(){
        System.out.println("BaseBTest --- afterBAll ");
    }

    @BeforeEach
    void beforeBEach(){
        System.out.println("BaseBTest --- beforeBEach ");
    }

    @AfterEach
    void afterBEach(){
        System.out.println("BaseBTest --- afterBEach ");
    }

    @Test
    void hogwarts3(){
        System.out.println("BaseBTest --- hogwarts1 ");
    }

    @Test
    void hogwarts4(){
        System.out.println("BaseBTest --- hogwarts2 ");
    }
}
