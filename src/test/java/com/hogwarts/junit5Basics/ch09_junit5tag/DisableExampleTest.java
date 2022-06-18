package com.hogwarts.junit5Basics.ch09_junit5tag;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @Disabled 如果禁用的是测试类，那么只有使用maven构建，才能提现出来
 */
@Disabled("禁用测试类")
public class DisableExampleTest {

    @Test
    void hogwarts1(){
        System.out.println("霍格沃兹测试学社禁用测试用例1");
    }

    @Test
    void hogwarts2(){
        System.out.println("霍格沃兹测试学社禁用测试用例2");
    }
}
