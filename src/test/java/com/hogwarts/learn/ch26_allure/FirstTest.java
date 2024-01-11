package com.hogwarts.learn.ch26_allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {

    @Test
    @DisplayName("allure报告")
    public void test1(){
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setName("修改用例名称"));
        int result = 3+2;
        assertEquals(5, result, "计算错误");
    }
}
