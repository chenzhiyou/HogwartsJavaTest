package com.hogwarts.junit5Basics.ceshiren;

import com.hogwarts.ceshiren.SumData;
import com.hogwarts.junit5Basics.self.ListAggregator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("加法运算")
public class CalculatorSumTest extends CalculatorBaseTest{

    static Stream<Arguments> ObjectProvider(){
        return Stream.of(
                Arguments.arguments(1, 1, 2),
                Arguments.arguments(99, 99, 198),
                Arguments.arguments(-99, 99, 0),
                Arguments.arguments(-99, -99, -198)
        );
    }

    @DisplayName("整数相加")
    @ParameterizedTest(name = "[{index}] {0}+{1}={2}")
    @MethodSource("ObjectProvider")
    void Ca_add_001(int num1, int num2, int num3){
        result = calculator.sum(num1, num2);
        assertEquals(num3, result);
    }

    @Test
    @DisplayName("三个整数相加")
    void Ca_add_002(){
        result = calculator.sum(1, 1, 9);
        assertEquals(11, result);
    }

    static Stream<Arguments> sumTest1(){
        return Stream.of(
                Arguments.arguments(Arrays.asList(1, 1), 2),
                Arguments.arguments(Arrays.asList(2, 3, 5), 20),
                Arguments.arguments(Arrays.asList(20, 3, 23, 23), 100)
        );
    }

    @DisplayName("整数相加")
    @ParameterizedTest(name = "[{index}] {0}+{1}={2}")
    @MethodSource("sumTest1")
    void Ca_add_003(List<Integer> add, int re){
        /**
         * List<Integer> 转为Stream<Integer>
         * Stream<Integer>流IntStream流
         * IntStream流 ---> int[]
         */
        result = calculator.sum(add.stream().mapToInt(Integer::intValue).toArray());
        assertEquals(re, result);
    }

    @Test
    @DisplayName("无效边界值相加，100+0")
    void Ca_add_006(){
//        int result = calculator.sum(100, 0);
        // 对异常结果的断言
        Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.sum(100,0));
        String message = exception.getMessage().toString();
        assertThat("失败断言", message, is(containsString("integer is 100")));
    }

    @Test
    @DisplayName("无效边界值相加，-100+(-1)")
    void Ca_add_007(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.sum(-100, 0));
        String message = exception.getMessage().toString();
        assertThat("失败断言", message, is(containsString("请输入范围内的整数！")));
    }

    @Test
    @DisplayName("无效边界值相加，2+100")
    void Ca_add_008(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.sum(100,2));
        String message = exception.getMessage().toString();
        assertThat("失败断言",message, is(containsString("integer is 100！")));
    }

    @Test
    @DisplayName("无效边界值相加，1+(-100)")
    void Ca_add_009(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.sum(1,-100));
        String message = exception.getMessage().toString();
        assertThat("失败断言",message, is(containsString("请输入范围内的整数！")));
    }

    // TODO:对异常数据结果的参数化：

    static Stream<Arguments> sumTest5(){
        return Stream.of(
                Arguments.arguments(true,Arrays.asList(1, 1), 2),
                Arguments.arguments(true,Arrays.asList(2, 3, 5), 10),
                Arguments.arguments(true,Arrays.asList(20, 3, 23, 23), 69),

                Arguments.arguments(false,Arrays.asList(1, 100), 0),
                Arguments.arguments(false,Arrays.asList(1, -100), 0)
        );

    }

    @ParameterizedTest
    @MethodSource("sumTest5")
    void add_ch005(boolean flag, List<Integer>add, int re){
        if (flag){
            result = calculator.sum(add.stream().mapToInt(Integer::intValue).toArray());
            assertEquals(re, result);
        }else {
            Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.sum(add.stream().mapToInt(Integer::intValue).toArray()));
            String message = exception.getMessage().toString();
            assertThat("失败断言",message, is(containsString("请输入范围内的整数！")));

        }
    }

    /**
     * 使用实体类进行参数化
     * @param sumData
     */
    @ParameterizedTest
    @MethodSource("sumTest5")
    void add_ch007(@AggregateWith(ListAggregator.class) SumData sumData){
        if (sumData.isFlag()){
            result = calculator.sum(sumData.getAdd().stream().mapToInt(Integer::intValue).toArray());
            assertEquals(sumData.getRe(), result);
        }else {
            Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.sum(sumData.getAdd().stream().mapToInt(Integer::intValue).toArray()));
            String message = exception.getMessage().toString();
            assertThat("失败断言",message, is(containsString("请输入范围内的整数！")));
        }
    }
}
