package com.hogwarts.junit5Basics.ch06_junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * 1、定义枚举类
 * 2、对测试方法添加ParameterizedTest注解和EnumSource注解
 * 3、测试方法的形参声明类型定的枚举类,可以通过names关键字，指定枚举对象的范围,
 *      通过mode关键字，指定规则EXCLUDE规则代表取反,
 *      MATCH_ALL代表正则匹配，在name中填写正则表达式
 */
public class EnumSourceDemoTest {

    public enum HogwartsUnit{

        Harry("Harrt", 18),
        AD("AD", 20),
        AD2("AD2", 20);

        private final String name;
        private final Integer age;

        private HogwartsUnit(String name, Integer age){
            this.name = name;
            this.age = age;
        }
    }

    @ParameterizedTest
    @EnumSource
    void enumSourceDemo(HogwartsUnit unit){
        System.out.println(unit.name + "的年龄： "+ unit.age);
    }

    @ParameterizedTest
    @EnumSource(names = {"AD"})
    void enumSourceDemo2(HogwartsUnit unit){
        System.out.println(unit.name + "的年龄： "+ unit.age);
    }

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE,names = {"AD"})
    void enumSourceDemo3(HogwartsUnit unit){
        System.out.println(unit.name + "的年龄： "+ unit.age);
    }

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.MATCH_ALL,names = {"AD.*"})
    void enumSourceDemo4(HogwartsUnit unit){
        System.out.println(unit.name + "的年龄： "+ unit.age);
    }
}
