package com.hogwarts.junit5Basics.ceshiren;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("字符串拼接")
public class CalculatorConcatStrTest extends CalculatorBaseTest{
    @Test
    @DisplayName("字符串拼接")
    void Ca_add_019(){
        strResult = calculator.concatStr("Hello", "Junit5");
        assertEquals("Hello Junit5", strResult);
    }

    @Test
    @DisplayName("字符串拼接")
    void Ca_add_020(){
        strResult = calculator.concatStr("你好", "世界");
        assertEquals("你好 世界", strResult);
    }

    @Test
    @DisplayName("字符串拼接")
    void Ca_add_021(){
        strResult = calculator.concatStr("这里", "是", "北京");
        assertEquals("这里 是 北京", strResult);
    }
}
