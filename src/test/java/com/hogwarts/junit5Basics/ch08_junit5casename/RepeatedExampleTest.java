package com.hogwarts.junit5Basics.ch08_junit5casename;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * 重复测试 使用RepeatedTest注解，注意不要和@Test结合，如果和@Test结合使用，就是RepeatedTest的执行次数+1
 * 在name =""中，所有的{}中的都是变量，其他的都是固定的格式
 * displayName 代表显示名称
 * */
public class RepeatedExampleTest {

    @RepeatedTest(3)
    void hogwarts(){
        System.out.println("霍格沃兹支付成功");
    }

    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition} of {totalRepetitions}")
    @DisplayName("hogwartsSchool")
    void hogwarts2(){
        System.out.println("霍格沃兹支付成功");
    }
}
