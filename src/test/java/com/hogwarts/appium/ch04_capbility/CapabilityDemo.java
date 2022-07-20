package com.hogwarts.appium.ch04_capbility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.app.SupportsAutoGrantPermissionsOption;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * deviceName 设备名称 不能唯一锁定一个设备
 * uid： 有多个设备的时候，要指定UID， 默认读取设备列表的第一个设备，设备列表： adb devices
 * newCommandTimeout appium程序应等待来自客户端的新命令多长时间，超时后会话删除，默认为60秒，设置为0禁用
 * PRINT_PAGE_SOURCE_ON_FIND_FAILURE 默认为false，发生任何错误，强制服务器将实际的XML页面源转储到日志中
 * autoGrantPermissions 授予APP启动的应用程序的某些权限，当noReset设置为true的时候，此参数不生效
 * 测试策略：
 *      noReset
 *          默认为false
 *          安卓true：
 *              不停止应用程序
 *              不清楚应用程序数据
 *              不卸载apk
 *      fullRest
 *          默认为false，true：新会话之前完全卸载被测应用程序
 *          安卓：
 *              在会话开始之前(appium启动APP)和测试之后停止应用程序
 *              清除应用程序数据并卸载apk
 *      dontStopAppOnReset:
 *          默认为false
 *          不希望应用程序在运行时重新启动，设置为true
 *
 */
public class CapabilityDemo {
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
        // 设置会话的超时时间
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        // 授予APP启动的应用程序的某些权限
        desiredCapabilities.setCapability(SupportsAutoGrantPermissionsOption.AUTO_GRANT_PERMISSIONS_OPTION, 30);
        desiredCapabilities.setCapability(MobileCapabilityType.PRINT_PAGE_SOURCE_ON_FIND_FAILURE, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void sampleTest() {
        WebElement searchEle = driver.findElement(AppiumBy.id("com.xueqiu.android:id/home_search"));
        boolean enabled = searchEle.isEnabled();
        System.out.println("当前搜索框是否可用： "+ enabled);
        String name = searchEle.getAttribute("name");
        // 查看当前输入框的name属性值
        System.out.println("搜索框的name属性为："+ name);
        // 获取搜索输入框的坐标，元素左上角坐标点
        Point searchLocation = searchEle.getLocation();
        System.out.println("搜索框的左上角坐标: "+ searchLocation);
        // 获取元素宽和高
        Dimension searchSize = searchEle.getSize();

        System.out.println("元素宽和高打印： "+ searchSize);
        // 点击搜索框
        searchEle.click();
        WebElement element = driver.findElement(AppiumBy.id("com.xueqiu.android:id/search_input_text"));
        System.out.println(element.getText());
        // 获取一些元素的相关属性
        boolean displayed = element.isDisplayed();
        System.out.println("元素是否可见: "+ displayed);
        String attribute = element.getAttribute("resource-id");
        System.out.println("resource-id： "+ attribute);
        element.clear();
        element.sendKeys("alibaba");
        System.out.println("-----------hhhh------------------");
        // 显示等待
//        WebElement element1 = new WebDriverWait(driver, Duration.ofSeconds(3))
//                .until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.xueqiu.android:id/home_search")));

        /**
         * 元素中心点
         * startX + 宽度/2
         * startY + 高度/2
         */
        int startX = element.getLocation().getX();
        int startY = element.getLocation().getY();
        Dimension size = element.getSize();
        int midd = size.getWidth()/2;
        int middH = size.getHeight()/2;
        int middleX = startX+ midd;
        int middleY = startY+ middH;

        WebElement el = driver.findElement(AppiumBy.id("com.xueqiu.android:id/name"));
        String text = el.getText();
        if (text.equals("阿里巴巴")){
            System.out.println("搜索成功");
        }else{
            System.out.println("搜索失败");
        }
        assertTrue(el.isDisplayed());
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

}
