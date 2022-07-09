package com.selenium.ch14_po;

import com.hogwarts.ch07_oop.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * PO六大原则之一：要用公共方法代表UI所提供的功能
 * 所有的初始页面，都需要添加这个方法
 * 不要暴露页面内部的元素给外部
 * 问题：元素定位没有统一维护，一旦页面发生变化，那么相关的定位都要修改
 * 解决方法：
 */
public class LoginPage extends BasePage{
    private final By userNameBy = By.name("username");
    private final By passWordBy = By.name("password");
    private final By loginButtonBy = By.xpath("//button");

    public LoginPage(String baseURL) {
        super(baseURL);
    }

    public LoginPage(WebDriver baseDriver) {
        super(baseDriver);
    }
    public MainPage Login(){
        // PO六大原则之一：方法应该返回其他的PageObject，或者返回用于断言的数据
        find(loginButtonBy).click();
        return new MainPage(driver,wait);
    }
}
