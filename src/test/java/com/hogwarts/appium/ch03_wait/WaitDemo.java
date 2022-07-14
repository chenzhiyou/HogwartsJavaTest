package com.hogwarts.appium.ch03_wait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDemo {

    public static AndroidDriver driver;

    @BeforeAll
    static void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "ab5e4675");
        desiredCapabilities.setCapability("platformVersion", "10.0");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("autoGrantpermission", "true");
        desiredCapabilities.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void sampleTest() {
        WebElement searchEle = driver.findElement(AppiumBy.id("com.xueqiu.android:id/home_search"));
        searchEle.click();
        WebElement element = driver.findElement(AppiumBy.id("com.xueqiu.android:id/search_input_text"));
        element.clear();
        element.sendKeys("alibaba");
        System.out.println("-----------hhhh------------------");
        // 显示等待
//        WebElement element1 = new WebDriverWait(driver, Duration.ofSeconds(3))
//                .until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.xueqiu.android:id/home_search")));


    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
