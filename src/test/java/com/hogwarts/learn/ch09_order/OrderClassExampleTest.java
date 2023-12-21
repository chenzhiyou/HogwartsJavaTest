package com.hogwarts.learn.ch09_order;

import org.junit.jupiter.api.*;

/**
 * 如果是对类排序，使用 @TestClassOrder
 * @TestClassOrder(ClassOrderer.OrderAnnotation.class) 需要配合@Order进行排序
 */
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class OrderClassExampleTest {

    @Nested
    @Order(1)
    class HogwartsOne{
        @Test
        void hogwarts(){
            System.out.println("HogwartsOne");
        }
    }

    @Nested
    @Order(2)
    class HogwartsTwo{
        @Test
        void hogwarts(){
            System.out.println("HogwartsTwo");
        }
    }
    @Nested
    @Order(3)
    class HogwartsThree{
        @Test
        void hogwarts(){
            System.out.println("HogwartsThree");
        }
    }
}
