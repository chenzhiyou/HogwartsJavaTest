package com.hogwarts.junit5Basics.ch16_allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AllureDisplayNameTest {

    @Test
    @DisplayName("静态用例名称")
    public void caseTitleTest(){
        assert 1+1 ==2;
        assertThat(2, equalTo(2));
    }

    @Test
    public void dynamicDescriptionTest(){
        Allure.description("动态描述信息");
    }

    @Test
    @Link(name = "静态连接", url = "https://www.baidu,com")
    public void staticLinkTest(){
        assert 1+1 ==2;
    }

    @Test
    @Links({@Link(name = "多个连接1", url = "https://www.baidu,com"),
            @Link(name = "多个连接2", url = "https://www.baidu,com")})
    public void staticLinksTest(){
        assert 1+1 ==2;
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void allureSeverityTest(){
        System.out.println("一般等级的case");
    }
}
