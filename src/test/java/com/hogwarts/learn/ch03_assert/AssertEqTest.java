package com.hogwarts.learn.ch03_assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertEqTest {

    @Test
    void hogwarts(){
        System.out.println("断言测试");
        assertEquals(2, 1+1);
    }
}
