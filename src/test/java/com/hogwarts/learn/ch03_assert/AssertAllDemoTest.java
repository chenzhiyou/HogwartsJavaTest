package com.hogwarts.learn.ch03_assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertAllDemoTest {

    @Test
    void allTest(){
        assertEquals(2, 1+1);
        assertAll("all",
                ()-> assertEquals(2,1+1),
                ()->assertEquals(3, 1+1),
                ()->assertEquals(4, 2+2));
    }
}
