package com.hogwarts.appium.ch06_actions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * 常用的设备交互命令：
 *      模拟电话、短信
 *      网络模式
 *      横竖屏切换
 *      APP处理
 *      录屏
 */
public class ChainTest {
    public static AndroidDriver driver;
    public static String PHONE_NUMBER="18332553176";

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
    public void makeGsmCallTest(){
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.CALL);
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.ACCEPT);
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.CANCEL);

        driver.sendSMS("555-123-4567", "AppiumTest");
    }
}
