package com.hogwarts.junit5Basics.ch06_junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class EmptySourceDemoTest {

    @ParameterizedTest
    @EmptySource
    void emptySourceDemo(String param){
        System.out.println(param);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void NullAndEmptySourceDemo(String param){
        System.out.println(param);
    }
}
