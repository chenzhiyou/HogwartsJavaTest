package com.hogwarts.junit5Basics.ch04_junit5assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertAllDemoTest {

    @Test
    void hogwarts(){
        // 问题： 只要有一个断言失败，后面的代码全部都不执行
        // 解决：使用assertAll即可实现，所有字段的断言
        assertEquals(2, 1+1);
        assertEquals(3, 1+1);
        assertEquals(1, 1+1);
    }

    @Test
    void assertAllDemo(){
        // 分组断言，如果一个用例存在多个断言，使用assertAll，可以每个断言都执行，且返回结果
        // 第一个heading参数是一个描述信息，代表了 这个分组断言是针对什么场景，也可以不穿
        System.out.println("断言测试assertAll场景");
        assertAll("NumberAssert",
                ()->assertEquals(2, 1+1),
                ()->assertEquals(3, 1+1),
                ()->assertEquals(4, 1+1));
    }

    @Test
    void assertAllDemo2(){
        // 把断言内容放到list内，统一进行断言
        ArrayList<Executable> executions = new ArrayList<Executable>();
        System.out.println("断言测试assertAll场景");
        executions.add(()->assertEquals(2, 1+1));
        executions.add(()->assertEquals(3, 1+1));
        executions.add(()->assertEquals(4, 1+1));
        assertAll("执行流", executions.stream());

    }
}
