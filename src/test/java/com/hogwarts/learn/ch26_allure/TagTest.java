package com.hogwarts.learn.ch26_allure;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

@Tag("1")
@Tag("2")
public class TagTest {

    @Test
    @Tag("你好")
    @Tag("世界")
    public void test1(){
        System.out.println("这是一个测试用例");
    }

    @Test
    @DisabledIf("nice")
    public void test2(){
        System.out.println("这是一个测试用例");
    }
    boolean nice(){
        return 2+2 ==5;
    }
}
