package com.hogwarts.junit5Basics.ch06_junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * MethodSource("")指定数据源的方法， 如果不添加参数，会找和测试方法同名的静态方法
 * 定义一个静态方法，提供参数化数据源的方法名
 * 添加形参，形参的类型，要和静态方法内部的元素类型一致
 */
public class MethodSourceDemoTest {

    @ParameterizedTest
    @MethodSource("stringProvider")
    void methodSourceDemo(String name){
        System.out.println(name);
    }

    static Stream<String> stringProvider(){
        return Stream.of("芒果", "苹果");
    }

    @ParameterizedTest
    @MethodSource
    void methodSourceDemo2(String name){
        System.out.println(name);
    }

    static Stream<String> methodSourceDemo2(){
        return Stream.of("芒果", "苹果");
    }

}
