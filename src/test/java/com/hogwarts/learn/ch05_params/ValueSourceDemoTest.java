package com.hogwarts.learn.ch05_params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueSourceDemoTest {

    @ParameterizedTest
    @ValueSource(strings = {"张三", "李四", "王五"})
    void valueSourceDemo(String name){
        System.out.println(name);
        assertEquals(name.length(),2);
    }
}
