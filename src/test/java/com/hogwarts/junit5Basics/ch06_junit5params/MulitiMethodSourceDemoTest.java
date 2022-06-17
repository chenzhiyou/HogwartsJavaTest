package com.hogwarts.junit5Basics.ch06_junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MulitiMethodSourceDemoTest {

    @ParameterizedTest
    @MethodSource("ObjectProvider")
    void mulitiMethodSourceDemo(String name, Integer age){
        System.out.println(name + "的年龄： "+ age);
    }


    /**
     * 返回的不再是 Stream<基本数据类型>，而是使用Arguments再包装了一层
     */
    static Stream<Arguments> ObjectProvider(){
        return Stream.of(
                Arguments.arguments("哈利", 5),
                Arguments.arguments("赫敏", 6)
        );
    }
}
