package com.hogwarts.appium.ch07_po.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * 雪球首页
 */
public class XueQiuAPP extends BasePage {

    public XueQiuAPP() {
        if (driver==null){
            startApp();
        }
    }

    public XueQiuAPP(AndroidDriver driver) {
        super(driver);
    }

    // 1、打开APP
    public XueQiuAPP startApp()   {
        if (driver==null){
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("deviceName", "ab5e4675");
            desiredCapabilities.setCapability("platformVersion", "10.0");
            desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
            desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
            desiredCapabilities.setCapability("autoGrantpermission", "true");
            desiredCapabilities.setCapability("noReset", true);

            URL remoteUrl = null;
            try {
                remoteUrl = new URL("http://localhost:4723/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }

        return this;
    }

    // 跳转到搜索页面
    public SearchPage toSearchPage(){
        // 点击搜索按钮
        find(AppiumBy.id("com.xueqiu.android:id/home_search")).click();
        return new SearchPage(driver);
    }

    public void quite(){
        driver.quit();
    }
}
