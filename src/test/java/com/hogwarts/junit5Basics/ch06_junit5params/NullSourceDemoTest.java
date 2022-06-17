package com.hogwarts.junit5Basics.ch06_junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

public class NullSourceDemoTest {

    @ParameterizedTest
    @NullSource
    void nullSourceDemo(String param){
        System.out.println(param);
    }
}
