package com.hogwarts.junit5Basics.ch02_rules;

import org.junit.jupiter.api.Test;

/**
 * IDEA 并没有针对文件名做限制
 * 使用maven构建时，则不会收集不满足规则要求的用例
 */
public class DemoHogwarts {
    @Test
    void demo(){
        System.out.println("DemoHogwarts");
    }
}
