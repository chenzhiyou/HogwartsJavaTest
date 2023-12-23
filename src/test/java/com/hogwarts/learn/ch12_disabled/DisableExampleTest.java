package com.hogwarts.learn.ch12_disabled;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

// Disabled如果禁用测试类，需要与Maven配合使用
//@Disabled
public class DisableExampleTest {

    @Test
    void hogwarts1(){
        System.out.println("禁用测试类");
    }

    @Disabled("禁用测试方法")
    @Test
    void hogwarts2(){
        System.out.println("禁用测试类");
    }
}
