package com.hogwarts.learn.ch03_assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AaaertNotNullTest {

    @Test
    void hogwarts(){
        System.out.println("断言测试");
        assertNotNull("null");
    }
}
