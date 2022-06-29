package com.hogwarts.selenium.ch06_webDriverWait;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitAdvancedTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    /**
     * 显示等待的第一种使用，结合ExpectedConditions进行使用
     * ExpectedConditions.elementToBeClickable的不同方法，有不同的返回值
     * wait.until的返回值就是括号内里面函数的返回值
     */
    @Test
    void waitByConditions(){
        driver.get("https://vip.ceshiren.com/#/ui_study/frame");
        WebElement waitElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("success_btn")));
        waitElement.click();

    }

    /**
     * 显示等待的第二种使用，自定义显示等待的执行逻辑与条件
     *
     */
    @Test
    void waitByLambda(){
        driver.get("https://vip.ceshiren.com/#/ui_study/frame");
        // 点击某个按钮，直到弹窗出现为止
        WebElement waitElement =wait.until(
                (driver) ->{
                    driver.findElement(By.id("primary_btn")).click();
                    return driver.findElement(By.xpath("//*[text()='该弹框点击两次后才会弹出']"));
                });
        String text = waitElement.getText();
        System.out.println(text);
    }

    /**
     * 流等待：
     *      与显示等待近似
     *      设定超时时间
     *      设定轮询频率
     *      忽略特定类型的异常
     *      更深层次的定制
     *          轮询频次
     *          忽略指定异常
     */
    @Test
    void fluentWait(){
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        driver.get("https://vip.ceshiren.com/#/ui_study/frame");
        // 点击某个按钮，直到弹窗出现为止
        WebElement waitElement =fluentWait.until(
                (driverInner) ->{
                    driverInner.findElement(By.id("primary_btn")).click();
                    return driverInner.findElement(By.xpath("//*[text()='该弹框点击两次后才会弹出']"));
                });
        String text = waitElement.getText();
        System.out.println(text);
    }
}
