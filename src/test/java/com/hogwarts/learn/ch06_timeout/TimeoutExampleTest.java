package com.hogwarts.learn.ch06_timeout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.lang.Thread.sleep;

public class TimeoutExampleTest {

    @BeforeEach
    @Timeout(3)
    void setUp() throws InterruptedException {
        sleep(4000);
        System.out.println("测试开始");
    }

    @Test
    @Timeout(3)
    void timeoutCaseOne() throws InterruptedException {
        System.out.println("第一条用例");
        sleep(10000);
    }

    @Test
    @Timeout(3)
    void timeoutCaseTwo()  {
        System.out.println("第一条用例");
    }
}
