package com.hogwarts.learn.ch10_repeated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

/**
 * @Test如果和@RepeatedTest结合使用，那么就多执行一次，所以不要和@Test一起使用
 * 在name = "{displayName}: {currentRepetition} of {totalRepetitions}"中，所有的{}中的都是变量，其他的都是固定格式
 * displayName代表显示名称，如果没有设定，那么会使用方法名称
 * currentRepetition 当前是第几次重复
 * totalRepetitions 总共需要重复几次
 */
public class RepeatedExampleTest {

//    @RepeatedTest(5)
    @RepeatedTest(value = 3, name = "{displayName}: {currentRepetition} of {totalRepetitions}")
    @DisplayName("重复测试")
    void hogwarts(){
        System.out.println("支付成功");
    }
}
