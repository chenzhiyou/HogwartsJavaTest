package com.hogwarts.junit5Basics.ch06_junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CsvFileSourceDemoTest {
    // 注意： 文件名前面需要加"/"
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void csvFileSourceDemo1(String name, Integer age){
        System.out.println(name + "的年龄是: " + age);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data2.csv", delimiterString = "|")
    void csvFileSourceDemo2(String name, Integer age){
        System.out.println(name + "的年龄是: " + age);
    }
}
