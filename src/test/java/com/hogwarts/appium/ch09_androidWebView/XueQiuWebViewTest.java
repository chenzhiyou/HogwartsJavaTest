package com.hogwarts.appium.ch09_androidWebView;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class XueQiuWebViewTest {
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
        // 进行webView测试，需要配置与手机端Chrome版本相对应的ChromeDriver
        desiredCapabilities.setCapability("chromedriverExecutable", " /Users/lixiaochen/Desktop/ChromeDriver/chromedriver");

        desiredCapabilities.setCapability("showChromedriverLog", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void XueQiuWebViewDemoTest() {
        driver.findElement(AppiumBy.xpath("//*[@text='交易']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElements(AppiumBy.xpath("//*[@text='开户']")).get(1).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextHandles = driver.getContextHandles();
        System.out.println(contextHandles);
        driver.context(contextHandles.toArray()[1].toString());
        System.out.println(contextHandles);
        driver.getWindowHandles();
        WebElement phoneEle = driver.findElement(By.id("phone-number"));
        phoneEle.clear();
        phoneEle.sendKeys("18332553176");

        WebElement codeEle = driver.findElement(By.id("code"));
        codeEle.clear();
        codeEle.sendKeys("123");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
