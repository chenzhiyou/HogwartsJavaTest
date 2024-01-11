package com.hogwarts.learn.ch26_allure;

import org.junit.jupiter.api.Test;

import java.io.IOException;
// 运行方式：mvn clean test allure:report -Dsurefire.rerunFailingTestsCount=3 指定重试次数
public class RetryTest {

    @Test
    public void retryTest() throws IOException {
        throw new IOException("IO 流异常");

    }
}
