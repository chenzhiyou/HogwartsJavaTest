package com.hogwarts.appium.ch01_record;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.MobileCommand.LAUNCH_APP;

/**
 * Capability简介
 *      功能：配置appium会话，告诉appium服务器需要自动化的平台的应用程序
 *      形式：键值对的集合，键对应设置的名称，值对应设置的值
 *      主要分为三部分：
 *          公共部分
 *              platformName 使用的手机操作系统
 *              platformVersion  手机操作系统的版本
 *              deviceName 使用的手机或模拟器类型
 *              automationName 使用哪个自动化引擎
 *              noReset 在当前session下不会重置应用的状态，默认值为false
 *          iOS部分
 *              bundleId
 *              udid
 *          Android部分
 *              appActivity 启动页
 *              appPackage 运营的Android应用的包名
 *              appWaitActivity 用于等待启动的Android activity名称
 *              unicodeKeyboard 启动Unicode输入，默认为false
 *              resetKeyboard
 *              dontStopAppOnReset  收起启动的时候，不停止APP
 *              skipDeviceInitialization 跳过安装，权限设置等操作
 *     session：appium的客户端和服务端之间进行通信的前提，通过Desired Capabilities建立会话
 */
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
        // ensureWebViresHavePage webview配置
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.ENSURE_WEBVIEWS_HAVE_PAGES, true);
        // 设置超时时间
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3600);

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
        // 热启动
        driver.execute(LAUNCH_APP);
        // 使用系统的返回按钮
        driver.navigate().back();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}








