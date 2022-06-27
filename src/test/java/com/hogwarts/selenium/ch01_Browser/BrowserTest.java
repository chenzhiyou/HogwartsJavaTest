package com.hogwarts.selenium.ch01_Browser;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

    public static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    @Test
    void windowGet(){
        driver.get("https://ceshiren.com");
    }

    // 测试用例-刷新页面
    @Test
    void windowRefresh(){
        driver.get("https://ceshiren.com");
        driver.navigate().refresh();
    }

    @Test
    void windowBack(){
        driver.get("https://ceshiren.com");
        driver.get("https://baidu.com");
        driver.navigate().back();

    }

    @Test
    void windowForward(){
        driver.get("https://ceshiren.com");
        driver.get("https://baidu.com");
        driver.navigate().back();
        // 调用 navigate的forward方法
        driver.navigate().forward();
    }

    // 浏览器窗口最大化
    @Test
    void windowMax(){
        driver.get("https://ceshiren.com");
        driver.manage().window().maximize();
    }

    // 浏览器窗口最小化
    @Test
    void windowMin(){
        driver.get("https://ceshiren.com");
        driver.manage().window().minimize();
    }
}

