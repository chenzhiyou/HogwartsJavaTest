package com.hogwarts.learn.ch26_allure;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayNameTest {

    @Test
    @DisplayName("减法计算")
    public void testDisplay(){
        int result = 9 -5;
        assertEquals(4, result, "减法计算错误");
    }

    @ParameterizedTest
    @CsvSource({"foo, 3", "hello, 5", "world, 5"})
    @DisplayName("测试字符串长度-参数化")
    void testStr(String str, int expected){
        assertEquals(expected, str.length());

    }

    @DisplayName("验证减法计算")
    @ParameterizedTest(name = "{0}- {1} = {2}")
    @MethodSource
    public void testSub(int a, int b , int re){
        int result = a -b;
        assertEquals(re, result, ()-> a+ "-" + b+ "的计算结果失败");
    }

    public static Stream<Arguments> testSub(){
        return Stream.of(
                Arguments.arguments(2, 2, 0),
                Arguments.arguments(4, 5, -1)
        );
    }
}
