package com.hogwarts.learn.ch09_order;

import org.junit.jupiter.api.*;

/**
 * @TestMethodOrder(MethodOrderer.OrderAnnotation.class) 指定排序方式通过Order注解排序
 * 注意需要通过@Order注解来配合使用
 * @TestMethodOrder(MethodOrderer.DisplayName.class) 需要通过@DisplayName注解配合使用
 * @TestMethodOrder(MethodOrderer.Random.class) 随机排序
 * @TestMethodOrder(MethodOrderer.MethodName.class) 通过方法名称进行排序
 */
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderExampleTest {

    @Test
//    @Order(1)
//    @DisplayName("a")
    void HogwartsOneTest(){
        System.out.println("第1条测试用例");
    }

    @Test
//    @Order(2)
//    @DisplayName("b")
    void HogwartsTwoTest(){
        System.out.println("第2条测试用例");
    }
    @Test
//    @Order(3)
//    @DisplayName("c")
    void HogwartsThreeTest(){
        System.out.println("第3条测试用例");
    }
    @Test
//    @Order(4)
//    @DisplayName("d")
    void HogwartsFourTest(){
        System.out.println("第4条测试用例");
    }
}
