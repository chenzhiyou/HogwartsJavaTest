package com.hogwarts.learn.ch24_calculator.num;

import com.hogwarts.learn.ch24_calculator.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubTest extends BaseTest {

    @Test
    @DisplayName("减法异常的测试用例")
    public void subException(){
        int num = calculator.subtract(100,8);
       assertEquals(0, num, "100-8计算错误");
    }
}
