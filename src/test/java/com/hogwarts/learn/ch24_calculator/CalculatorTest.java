package com.hogwarts.learn.ch24_calculator;

import learn.ch36_calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.api.function.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 1、创建计算器对象  --- new有参构造，传入参数值为：计算器
 * 2、log日志打印：开始进行加法计算
 * 3、业务逻辑调用  获取结果值 int  result
 * 4、log日志打印计算结果：计算结果为{}
 * 5、断言 --- assertEquals()
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("计算器测试用例")
public class CalculatorTest extends BaseTest{

    @ParameterizedTest(name = "{0} + {1} = {2}") // 直接使用下标就可以啦
    @CsvSource(value={"2,2,4", "4,5,9", "8,3,11"})
    @Order(1)
    @DisplayName("参数化的加法测试方法")
    public void sumParaByCsvTest(int num1, int num2, int result){
        sum = calculator.sum(num1+num2);
        assertEquals(result, sum, "计算结果不正确： ");

    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("sumParaMethodSource")
    @Order(2)
    @DisplayName("MethodSource参数化方式进行计算")
    public void sumParaMethodSourceTest(int num1, int num2, int result){
        sum = calculator.sum(num1+num2);
        assertEquals(result, sum, "计算结果不正确： ");
    }
    static Stream<Arguments> sumParaMethodSource(){
        return Stream.of(
                Arguments.arguments(2, 2,4),
                Arguments.arguments(4, 5, 9),
                Arguments.arguments(8,3, 11)
        );
    }
    @Test
    @Order(3)
    @DisplayName("加法正向的测试")
    public void sumTest(){
        sum = calculator.sum(2, 2);
        assertEquals(4, sum, "计算结果不正确： ");

    }

    @Test
    @Order(4)
    @DisplayName("三个参数的加法测试")
    public void sumThreeTest(){
        sum = calculator.sum(4, 3, 8);
        assertEquals(15, sum, "计算结果不正确： ");
    }

    @Test
    @Order(5)
    @DisplayName("边界值测试")
    public void sumNumberFormatExceptionTest(){
        NumberFormatException numberFormatException = assertThrows(NumberFormatException.class, () -> {
            calculator.sum(100, 0);
        });
        message = numberFormatException.getMessage();
        assertTrue(message.contains("integer is 100！"));
    }

    @Test
    @Order(6)
    @DisplayName("边界值测试")
    public void sumIllegalArgumentExceptionTest(){
        /**
         * 异常断言：
         * expectedType 抛出的异常类型
         * executable 异常业务流
         */
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sum(-100, 8);
        });
        message = illegalArgumentException.getMessage();
        assertTrue(message.contains("请输入范围内的整数！"));
    }

    @Test
    public void testOne(){
        List<Executable> assertList = new ArrayList<>();
        int sumRe = calculator.sum(66,6);
        assertEquals(72, sumRe);
        assertList.add(()->assertEquals(72, sumRe));
        int subRe = calculator.subtract(20, 3, 6);
        assertEquals(71, subRe);
        assertList.add(()->assertEquals(71, subRe));
        String str = calculator.concatStr(String.valueOf(subRe), "Good");
        assertEquals("71 Good", str);
        assertThat(str, is(containsString("Good")));
        assertList.add(()->assertThat(str, is(containsString("Good"))));
        assertAll("计算器结果失败",assertList);
        assertAll("计算器结果失败",
                ()->assertEquals(72, sumRe),
                ()->assertEquals(71, subRe),
                ()->assertThat(str, is(containsString("Good")))
        );
    }

}
