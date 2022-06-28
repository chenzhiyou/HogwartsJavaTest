package com.hogwarts.selenium.ch04_interaction;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InteractionTest {

    public static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    // 输入、清空、点击操作
    @Test
    void interactionTest(){
        driver.get("https://www.sogou.com");
        driver.findElement(By.id("query")).sendKeys("霍格沃兹测试开发");
        driver.findElement(By.id("query")).clear();
        driver.findElement(By.id("stb")).click();
    }

    @Test
    void getAttrbute(){
        driver.get("https://vip.ceshiren.com/#/ui_study/frame");
        WebElement locate_ele = driver.findElement(By.id("locate_id"));
        System.out.println(locate_ele.getText());
        System.out.println(locate_ele.getAttribute("style"));
    }

}
