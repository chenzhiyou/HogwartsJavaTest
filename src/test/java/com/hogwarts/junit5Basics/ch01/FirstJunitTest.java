package com.hogwarts.junit5Basics.ch01;

import org.junit.jupiter.api.Test;

/**
 * 如果使用mvn进行执行，1、安装对应的两个plugin 2、一定要在对应module路径下面执行 mvn test
 */
public class FirstJunitTest {
    @Test
    void first(){
        System.out.println("第一个Junit5测试用例");
    }

    @Test
    void second(){
        System.out.println("第二个Junit5测试用例");
    }
}
