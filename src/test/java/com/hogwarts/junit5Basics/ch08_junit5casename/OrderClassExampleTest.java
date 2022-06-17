package com.hogwarts.junit5Basics.ch08_junit5casename;

import org.junit.jupiter.api.*;

/**
 * 如果对类排序，需要使用TestClassOrder
 * @TestClassOrder(ClassOrderer.OrderAnnotation.class)
 * @TestClassOrder(ClassOrderer.DisplayName.class)
 */

@TestClassOrder(ClassOrderer.DisplayName.class)
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
