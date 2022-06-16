package com.hogwarts.junit5Basics.ch04_junit5assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertNoNullTest {

    @Test
    void nullDemo(){
        System.out.println("断言为空的场景");
        assertNotNull(null);
    }

    @Test
    void notNullDemo(){
        System.out.println("断言传值不为空的场景");
        assertNotNull(1);
    }
}
