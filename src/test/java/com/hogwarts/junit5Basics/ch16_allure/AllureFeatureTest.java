package com.hogwarts.junit5Basics.ch16_allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Feature("登录操作")
public class AllureFeatureTest {

    @Test
    @Story("登录成功")
    public void testSomething(){
        System.out.println("success");
    }

    @Test
    @Story("登录失败")
    public void testSomething1(){
        Allure.step("测试步骤1", this::stepLogic);
        System.out.println("fail");
        Allure.step("测试步骤2", this::stepLogic2);
    }

    @Step("测试步骤1")
    private void stepLogic(){
        System.out.println("测试步骤1");
    }

    @Step("测试步骤2")
    private void stepLogic2(){
        System.out.println("测试步骤2");
    }
}
