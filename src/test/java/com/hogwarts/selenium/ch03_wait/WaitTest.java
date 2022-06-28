package com.hogwarts.selenium.ch03_wait;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * 隐式等待是全局配置，强制等待和显示等待都是非全局的，只是针对某些元素生效
 */
public class WaitTest {

    public static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    @Test
    void waitTest() throws InterruptedException {
        driver.get("https://vip.ceshiren.com");
        // 强制等待
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='个人中心']"));
    }

    // 隐式等待, 是一个全局性的配置
    @Test
    void implicitlyWaitTest(){
        driver.get("https://vip.ceshiren.com");
        driver.findElement(By.xpath("//*[text()='个人中心']"));
    }

    @Test
    void waitUntilTest(){
        driver.get("https://vip.ceshiren.com/#/ui_study");
        WebElement message_btn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("success_btn")));
        message_btn.click();

    }
}
