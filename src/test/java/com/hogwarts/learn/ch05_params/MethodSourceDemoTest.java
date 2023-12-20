package com.hogwarts.learn.ch05_params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * 添加形参，形参的类型，要和静态方法内部的元素类型一致
 * @MethodSource()，如果不加参数，会找和测试方法同名的静态方法
 */
public class MethodSourceDemoTest {
    // 单参数
    @ParameterizedTest
    @MethodSource("stringProvider")
    void methodSourceDemo(String name){
        System.out.println(name);

    }

    // 定义一个静态方法，提供参数化数据源
    static Stream<String> stringProvider(){
        return Stream.of("芒果", "苹果");
    }

    //多参数
    @ParameterizedTest
    @MethodSource("objectProvider")
    void multiMethodSourceDemo(String name, Integer age){
        System.out.println(name+"的年龄是： "+ age);
    }

    static Stream<Arguments> objectProvider(){
        return Stream.of(
                Arguments.arguments("张三", 5),
                Arguments.arguments("李四", 6)
        );
    }
}
