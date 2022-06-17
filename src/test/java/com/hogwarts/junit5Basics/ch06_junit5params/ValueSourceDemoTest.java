package com.hogwarts.junit5Basics.ch06_junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class ValueSourceDemoTest {
    // 声明测试类是一个参数化的测试类
    @ParameterizedTest
    // 使用单参数注册ValueSource 传递参数化的数据内容
    // 传递参数的过程中，需要通过ValueSource 定义的关键字进行类型声明
    //在测试方法上面添加形参，接受参数化的数据
    @ValueSource(strings = {"张三", "李四", "王五"})
    void valueSourceDemo(String name){
        System.out.println(name);
        // 断言数据的长度是否等于2
        assertEquals(name.length(), 2);
    }
}
