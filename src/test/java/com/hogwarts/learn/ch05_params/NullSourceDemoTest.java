package com.hogwarts.learn.ch05_params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class NullSourceDemoTest {

    @ParameterizedTest
    @NullSource
    void nullSourceDemo(String param){
        System.out.println(param);
    }

    @ParameterizedTest
    @EmptySource
    void EmptySourceDemo(String param){
        System.out.println(param);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptySourceDemo(String param){
        System.out.println(param);
    }
}
