package com.hogwarts.learn.ch05_params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class EnumSourceDemoTest {
    public enum HogwartsUnit{

        Harry("harry", 18),
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
        System.out.println(unit.name+ "的年龄是： "+ unit.age);
    }

    // 通过names关键字，指定枚举对象的范围
    @ParameterizedTest
    @EnumSource(names = "AD")
    void enumSourceDemo2(HogwartsUnit unit){
        System.out.println(unit.name+ "的年龄是： "+ unit.age);
    }

    // 通过mode关键字，指定规则，EXCLUDE代表取反
    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = "AD")
    void enumSourceDemo3(HogwartsUnit unit){
        System.out.println(unit.name+ "的年龄是： "+ unit.age);
    }

    // 通过mode关键字，指定规则，MATCH_ALL代表正则
    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.MATCH_ALL, names = "AD.*")
    void enumSourceDemo4(HogwartsUnit unit){
        System.out.println(unit.name+ "的年龄是： "+ unit.age);
    }
}
