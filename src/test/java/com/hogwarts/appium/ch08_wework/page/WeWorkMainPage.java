package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.app.SupportsAutoGrantPermissionsOption;
import io.appium.java_client.ios.options.wda.SupportsWaitForIdleTimeoutOption;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WeWorkMainPage extends BasePage{
    public WeWorkMainPage(AndroidDriver driver) {
        super(driver);
    }

    public WeWorkMainPage() {
        if (driver==null){
            startApp();
        }
    }

    public WeWorkMainPage startApp(){
        if (driver==null){
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("deviceName", "ab5e4675");
            desiredCapabilities.setCapability("platformVersion", "10.0");
            desiredCapabilities.setCapability("appPackage", "com.tencent.wework");
            desiredCapabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
            desiredCapabilities.setCapability("autoGrantpermission", "true");
            desiredCapabilities.setCapability("noReset", true);
            // 当页面出错时，获取页面的page_source
            desiredCapabilities.setCapability(MobileCapabilityType.PRINT_PAGE_SOURCE_ON_FIND_FAILURE, true);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300000);
            // Android设备需要的初始化权限全部开通
            desiredCapabilities.setCapability(SupportsAutoGrantPermissionsOption.AUTO_GRANT_PERMISSIONS_OPTION, true);
            desiredCapabilities.setCapability(SupportsWaitForIdleTimeoutOption.WAIT_FOR_IDLE_TIMEOUT_OPTION, 0);

            URL remoteUrl = null;
            try {
                remoteUrl = new URL("http://localhost:4723/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
            // 添加隐式等待，最长不超过30
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
            // 声明显示等待
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofSeconds(2));

        }
        return this;
    }

    public ContactPage switchToContactPage(){
        // 点击通讯录, 修改定位方式为css定位
        driver.findElement(AppiumBy.xpath("//*[@text='通讯录']")).click();
//        driver.findElement(AppiumBy.cssSelector("[text='通讯录']")).click();
        return new ContactPage(driver);
    }

    public WorkPage switchToWorkPage(){
        // 点击工作台，进入到工作台界面
        driver.findElement(AppiumBy.xpath("//*[@text='工作台']")).click();
        return new WorkPage(driver);
    }
}
