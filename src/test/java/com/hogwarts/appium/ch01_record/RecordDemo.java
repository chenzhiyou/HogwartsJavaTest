package com.hogwarts.appium.ch01_record;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RecordDemo {
    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("devicesName", "ab5e4675");
        desiredCapabilities.setCapability("appActivity", ".ui.SplashActivity");
        desiredCapabilities.setCapability("appPackage", "com.didiglobal.express.driver");
        // 进行参数优化，保留历史数据
        desiredCapabilities.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        // 添加隐式等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void sampleTest() {
        WebElement el1 = (WebElement) driver.findElement(AppiumBy.id("com.didiglobal.express.driver:id/btn_confirm"));
        el1.click();
        WebElement el2 = (WebElement) driver.findElement(AppiumBy.id("com.didiglobal.express.driver:id/btn_login"));
        el2.click();
        WebElement el3 = (WebElement) driver.findElement(AppiumBy.id("com.didiglobal.express.driver:id/et_phone"));
        el3.sendKeys("00016102556");
        WebElement el4 = (WebElement) driver.findElement(AppiumBy.id("com.didiglobal.express.driver:id/cb_law"));
        el4.click();
        WebElement el5 = (WebElement) driver.findElement(AppiumBy.id("com.didiglobal.express.driver:id/custom_btn_text"));
        el5.click();
        // 使用系统的返回按钮
        driver.navigate().back();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}








