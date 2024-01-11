package com.hogwarts.learn.ch26_allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("步骤方法测试")
@Epic("购物平台")
@Epic("需求1")
@Feature("订单模块")
public class StepMethodTest {
    int result;

    @Test
    @DisplayName("加法步骤验证")
    @Story("通过用户名密码登录")
    @Description("这是一个测试用例描述")
    @Severity(SeverityLevel.BLOCKER)
    void sumTest(){
        Allure.step("输入数字 3");
        int a = pressDigit(3);
        Allure.step("输入加号");
        String str = pressAddition();
        Allure.step("输入数字 2");
        int b = pressDigit(2);
        Allure.step("点击等号");
        result = sum(a+b);
        Allure.step("验证结果是否正确");
        assertEquals(5, result, a +str + b + "计算错误");
    }

    @Test
    @DisplayName("一个测试方法中添加多个大步骤")
    @Story("通过账号登录")
    void stepTest(){
        List<Executable> list = new ArrayList<>();
        Allure.description("测试用例描述方法");
        Allure.step("步骤1", ()->{
            System.out.println("登录");
            Allure.step("输入用户名");
            String name = "admin";
            Allure.step("输入密码");
            String pwd = "123456";
            Allure.step("点击登录");;
            String login = name+ pwd;
            list.add(()->assertEquals("admin123456", login));
        });
        Allure.step("步骤2", ()->{
            System.out.println("搜索");
        });

        Allure.step("步骤3", ()->{
            System.out.println("播放");
        });
        assertAll(list);
    }


    private int pressDigit(int digit){
        return digit;
    }
    private String pressAddition(){
        return "+";
    }

    public int sum(int... numbers){
        return IntStream.of(numbers).sum();
    }

}
