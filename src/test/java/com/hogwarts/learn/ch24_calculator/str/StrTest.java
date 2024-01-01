package com.hogwarts.learn.ch24_calculator.str;

import com.hogwarts.learn.ch24_calculator.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrTest extends BaseTest {
    @Test
    @DisplayName("字符串拼接")
    public void strConcatTest(){
        result = calculator.concatStr("Hello", "Junit5");
        assertEquals("Hello Junit5", result, "拼接结果不正确");
    }

}
