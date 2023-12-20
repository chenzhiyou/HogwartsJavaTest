package com.hogwarts.learn.ch05_params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * CsvSource注解传递参数化数据，传递的参数格式是一个集合
 * 如果是多个参数，使用默认分隔符, 分开
 * 使用delimiterString指定分隔符，使用value 指定数据源
 */
public class CsvSourceDemoTest {

    @ParameterizedTest
    @CsvSource({"哈利, 2", "赫敏, 22", "罗恩, 12"})
    void csvSourceDemo(String name, Integer age){
        System.out.println(name+"的年龄是： "+ age);
    }

    @ParameterizedTest
    @CsvSource(value = {"哈利|2", "赫敏|22", "罗恩|12"}, delimiterString = "|")
    void csvSourceDemo2(String name, Integer age){
        System.out.println(name+"的年龄是： "+ age);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void csvFileSourceDemo(String name, Integer age){
        System.out.println(name+"的年龄是： "+ age);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data2.csv", delimiterString = "|")
    void csvFileSourceDemo2(String name, Integer age){
        System.out.println(name+"的年龄是： "+ age);
    }
}
