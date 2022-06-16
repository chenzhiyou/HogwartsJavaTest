package com.hogwarts.junit5Basics.ch04_junit5assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueTest {
    @Test
    void expressionDemo(){
        System.out.println("断言表达式为True");
        assertTrue(3>1);
    }

    @Test
    void booleanDemo(){
        //只要括号内的结果断言为true，就成功，否则直接失败
        System.out.println("断言布尔类型");
        assertTrue(false);

    }
}
