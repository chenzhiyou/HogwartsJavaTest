package com.hogwarts.learn.ch26_allure;

import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("链接地址测试")
public class LinkAndIssueAnTest {
    @Test
    @DisplayName("加法计算")
    @Link(name = "百度首页", url = "https://www.baidu.com", type = "sumlink")
    public void linkTest(TestInfo testInfo){
        int result = 3+2;
        assertEquals(5, result, "计算错误");
        Link link = testInfo.getTestMethod().get().getAnnotation(Link.class);
        System.out.println(link.name());
        System.out.println(link.url());
    }

    @Test
    @DisplayName("加法计算")
    @Issue( "https://www.baidu.com")
    public void issueTest(TestInfo testInfo){
        int result = 3+2;
        assertEquals(5, result, "计算错误");
        Issue issue = testInfo.getTestMethod().get().getAnnotation(Issue.class);

    }
}
