package com.hogwarts.junit5Basics.ch04_junit5assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertEqTest {

    @Test
    void hogwarts(){
        System.out.println("断言测试");
        // 第一个参数是期望结果，第二个参数是实际结果，对比两个参数是否相等
        assertEquals(2, 1+1);
    }
}
