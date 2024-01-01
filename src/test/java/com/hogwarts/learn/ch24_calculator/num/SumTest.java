package com.hogwarts.learn.ch24_calculator.num;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.hogwarts.learn.ch16_yaml.OrderLine;
import com.hogwarts.learn.ch24_calculator.BaseTest;
import learn.ch36_calculator.entity.Data;
import learn.ch36_calculator.entity.dataEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SumTest extends BaseTest {
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

    /**
     * 参数化的数据源在其他类中，引用格式为：包名.类名#数据源方法名
     * @param data
     */
    @ParameterizedTest(name = "{0}")
    @MethodSource("com.hogwarts.learn.ch24_calculator.source.SumYamlSource#sumParaYaml")
    public void sumParaYamlTest(dataEntity data){
        System.out.println(data);
        List<Executable> assertList = new ArrayList<>();
        int sumR;
        String str;
        if (data.getMessage().contains("有效")){
            sumR = calculator.sum(data.getA(), data.getB());
            assertList.add(()->assertEquals(data.getResult(), sumR));
        }else if (data.getMessage().contains("无效")){
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                calculator.sum(data.getA(), data.getB());
            });
            str = illegalArgumentException.getMessage();
            assertList.add(()-> assertTrue(str.contains("请输入范围内的整数！")));
        }
        assertAll(assertList);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("sumParaYaml")
    public void sumParaYamlTest2(dataEntity data){
        System.out.println(data);
        List<Executable> assertList = new ArrayList<>();
        int sumR;
        String str;
        if (data.getMessage().contains("有效")){
            sumR = calculator.sum(data.getA(), data.getB());
            assertList.add(()->assertEquals(data.getResult(), sumR));
        }else if (data.getMessage().contains("无效")){
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                calculator.sum(data.getA(), data.getB());
            });
            str = illegalArgumentException.getMessage();
            assertList.add(()-> assertTrue(str.contains("请输入范围内的整数！")));
        }
        assertAll(assertList);
    }

    static Stream<dataEntity> sumParaYaml() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        Data data;
        TypeReference<Data> typeReference =
                new TypeReference<Data>() {
                };
        data = objectMapper.readValue(new File("src/test/resources/data.yaml"), typeReference);
//        List<dataEntity> datas = data.getDatas();
        return data.getDatas().stream();
    }

}
