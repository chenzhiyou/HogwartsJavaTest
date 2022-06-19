package com.hogwarts.junit5Basics.ceshiren;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorSubtractTest extends CalculatorBaseTest{

    static Stream<Arguments> ObjectProvider(){
        return Stream.of(
                Arguments.arguments(10, 10, 0),
                Arguments.arguments(99, 99, 0),
                Arguments.arguments(-99, 99, -198),
                Arguments.arguments(99, -99, 198),
                Arguments.arguments(-99, -99, 0)
        );
    }
    @DisplayName("2个整数相减")
    @ParameterizedTest
    @MethodSource("ObjectProvider")
    void Ca_add_010(int num1, int num2, int num3){
        result = calculator.subtract(num1, num2);
        assertEquals(num3, result);
    }


    static Stream<Arguments> FailNumber(){
        return Stream.of(
                Arguments.arguments(100, 0),
                Arguments.arguments(2, 100),
                Arguments.arguments(1, -100)

        );
    }

    @ParameterizedTest
    @MethodSource("FailNumber")
    @DisplayName("无效边界值 ")
    void Ca_add_016(int num1, int num2){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.subtract(num1,num2));
        String message = exception.getMessage().toString();
        assertThat("失败断言", message, is(containsString("请输入范围内的整数！")));

    }
}
