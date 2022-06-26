package com.hogwarts.junit5Basics.ceshiren;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    static Stream<Arguments> str1Test(){
        return Stream.of(
                Arguments.arguments(Arrays.asList("Hello", "Junit5"), "Hello Junit5"),
                Arguments.arguments(Arrays.asList("中国", "欢迎", "您"), "中国 欢迎 您"),
                Arguments.arguments(Arrays.asList("这里", "是", "北京", "天安门"), "这里 是 北京 天安门")
        );
    }

    /**
     * 参数个数不确定的参数化
     * @param stringList
     * @param strRe
     */
    @ParameterizedTest
    @MethodSource
    void str1Test(List<String> stringList, String strRe){
        strResult = calculator.concatStr(stringList.stream().toArray(String[]:: new));
        assertEquals(strRe, strResult);

    }
}
