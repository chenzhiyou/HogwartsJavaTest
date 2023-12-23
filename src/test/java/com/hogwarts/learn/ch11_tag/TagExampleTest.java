package com.hogwarts.learn.ch11_tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TagExampleTest {
    // 通过tag(标签名)注解，即可设置标签， 每个用例可以有多个Tag
    @Test
    @Tag("preprod")
    void hogwarts1(){
        System.out.println("预发布环境");
    }

    @Test
    @Tag("dev")
    void hogwarts2(){
        System.out.println("开发环境");
    }

    @Test
    @Tag("test")
    void hogwarts3(){
        System.out.println("测试环境");
    }

    @Test
    @Tag("preprod")
    @Tag("test")
    void hogwarts4(){
        System.out.println("测试+预发布环境");
    }


    @PreprodTest
    void hogwarts5(){
        System.out.println("自定义标签");
    }
}
