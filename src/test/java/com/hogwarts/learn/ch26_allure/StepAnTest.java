package com.hogwarts.learn.ch26_allure;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("步骤注解验证")
public class StepAnTest {
    int result;

    @Test
    @DisplayName("加法步骤验证")
    @Step("==加法步骤验证==")
    void sumTest(){
        int a = pressDigit(3);
        String str = pressAddition();
        int b = pressDigit(2);
        result = sum(a+b);
        assertEquals(5, result, a +str + b + "计算错误");
    }


    @Step("输入数字 {digit}")
    private int pressDigit(int digit){
        return digit;
    }
    @Step("输入加号")
    private String pressAddition(){
        return "+";
    }

    public int sum(int... numbers){
        return IntStream.of(numbers).sum();
    }

}
