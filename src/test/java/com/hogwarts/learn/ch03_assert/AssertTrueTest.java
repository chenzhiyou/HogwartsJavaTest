package com.hogwarts.learn.ch03_assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueTest {

    @Test
    void expressionDemo(){
        System.out.println("断言表达式为true");
        assertTrue(3>1);
    }

    @Test
    void booleanDemo(){
        System.out.println("断言表达式为true");
        assertTrue(true);
    }
}

