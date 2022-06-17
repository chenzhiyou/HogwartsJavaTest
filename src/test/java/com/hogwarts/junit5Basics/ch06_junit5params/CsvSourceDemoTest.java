package com.hogwarts.junit5Basics.ch06_junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 1、使用ParameterizedTest注册声明是一个参数化的测试类
 * 2、使用CsvSource注册传递参数化数据,传递的参数格式是一个集合
 * 如果是多个参数，使用默认分隔符,分开; 使用delimiterString来执行分隔符
 */
public class CsvSourceDemoTest {

    @ParameterizedTest
    @CsvSource({"哈利,2", "赫敏, 22", "罗恩 , 12"})
    void csvSourceDemo(String name, Integer age){
        System.out.println(name + "的年龄是: " + age);
    }

    @ParameterizedTest
    @CsvSource(value = {"哈利|2", "赫敏|22", "罗恩|12"}, delimiterString = "|")
    void csvSourceDemo2(String name, Integer age){
        System.out.println(name + "的年龄是: " + age);
    }
}
