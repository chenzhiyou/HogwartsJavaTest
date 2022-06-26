package com.hogwarts.junit5Basics.ceshiren;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Str1Test extends CalculatorBaseTest{

    @Test
    void strAssertAllTest(){
        List<Executable> list = new ArrayList<Executable>();
        // 1、登录业务逻辑 --- 字符串拼接
        String resultStr = calculator.concatStr("hello", "你好");
//        assertEquals("hello 你好", resultStr, "中英文拼接");
        list.add(()->assertEquals("hello 你好", resultStr, "中英文拼接"));
        // 2、商品查看逻辑 --- 加法逻辑
        System.out.println("开始商品浏览");
        int sum = calculator.sum(3, 5, 2);
//        assertThat("2个数相加",sum, is(equalTo(10)));
        list.add(()->assertThat("2个数相加",sum, is(equalTo(10))));
        assertAll("多断言描述",list);
    }
}
