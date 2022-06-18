package com.hogwarts.junit5Basics.ch09_junit5tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * 通过tag，如果配置了pom文件，再使用mvn进行执行，pom的权限更高
 */
public class TagExampleTest {

    @Tag("preprod")
    @Test
    void hogwarts1(){
        System.out.println("预发布环境");
    }

    @Tag("test")
    @Test
    void hogwarts2(){
        System.out.println("开发环境");
    }

    @Tag("preprod")
    @Tag("test")
    @Test
    void hogwarts3(){
        System.out.println("预发布环境+测试环境");
    }

}
