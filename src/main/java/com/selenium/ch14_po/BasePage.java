package com.selenium.ch14_po;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * BasePage的定位是和业务无关的公共方法的封装，比如driver的初始化
 *
 */
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public FluentWait<WebDriver> fluentWait;
    public String baseURL;
    public Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(String baseURL) {
        // 当传入String类型的URL, 我们认为是用例的开始也就是一个初始页面，所以需要初始化driver
        this.baseURL = baseURL;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    public BasePage(WebDriver baseDriver){
        this.driver = baseDriver;
    }

    // find的底层提交
    public WebElement find(By by){
        logger.debug("查找的元素为"+ by);
       return driver.findElement(by);
    }

    // 封装流等待的方法
    public FluentWait<WebDriver> getFluentWait(){
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementClickInterceptedException.class);
        return fluentWait;
    }

    public void getURL(String URL){
        logger.debug("跳转页面到: " + URL);
        driver.get(URL);
    }

    public void quitDriver(){
        driver.quit();
    }
}
