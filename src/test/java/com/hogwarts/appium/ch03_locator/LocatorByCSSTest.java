package com.hogwarts.appium.ch03_locator;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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
 * 原生定位：
 *      ID定位：
 *          WebElement element1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector()
 *      .resourceId(\"<element-ID>\")"))
 *      组合定位：
 *          WebElement element1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector()
 *      .resourceId(\"com.xueqiu.android:id/tab_name\").text(\"股票\")"))
 * CSS定位：
 *      android.widget.TextView[description="some description"]
 *      new UiSelector().className("android.widget.TextView").description("some description")
 *
 */
public class LocatorByCSSTest {
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
//        WebElement searchEle = driver.findElement(AppiumBy.id("com.xueqiu.android:id/home_search"));
        // 使用Android的原生定位
//        WebElement searchEle = driver.findElement(AppiumBy.androidUIAutomator("" +
//                "new UiSelector.resourceId('com.xueqiu.android:id/home_search')"));

        // 使用CSS定位
        WebElement searchEle = driver.findElement(AppiumBy.cssSelector("#com\\.xueqiu\\.android\\:id\\/home_search"));
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
//        WebElement element = driver.findElement(AppiumBy.id("com.xueqiu.android:id/search_input_text"));

        // 使用CSS定位
        WebElement element = driver.findElement(AppiumBy.cssSelector("#com\\.xueqiu\\.android\\:id\\/search_input_text"));
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

        WebElement el = driver.findElement(AppiumBy.id("com.xueqiu.android:id/name"));
        // 使用CSS定位
        WebElement xpathElement = driver.findElement(AppiumBy.cssSelector("[text='阿里巴巴']"));
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
