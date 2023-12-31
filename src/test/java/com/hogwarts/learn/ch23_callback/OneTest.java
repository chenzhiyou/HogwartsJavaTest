package com.hogwarts.learn.ch23_callback;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({
        CallExtension.class,
        TimeExtension.class
})
public class OneTest {

    @BeforeAll
    public static void bf(){
        System.out.println("OneTest ---- BeforeAll");
        System.out.println("数据库中----创建用户表");
    }

    @BeforeEach
    public void be(){
        System.out.println("OneTest ---- BeforeEach");
        System.out.println("数据库中---提示说明对表的数据要进行操作");
    }

    @AfterEach
    public void ae(){
        System.out.println("OneTest ---- AfterEach");
        System.out.println("数据库中---更新数据时事务的提交");
    }

    @AfterAll
    public static void af(){
        System.out.println("OneTest ---- AfterAll");
        System.out.println("数据库中---创建用户表");
    }

    @Test
    public void test1(){
        System.out.println("数据库中---添加用户的业务逻辑");
    }
    @Test
    public void test2(){
        System.out.println("数据库中---更新用户的业务逻辑");
    }
}
