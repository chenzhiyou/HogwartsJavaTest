package com.hogwarts.appium.ch09_androidWebView;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
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
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * webView与手机创建连接的过程：
 * 建立PC与手机端本地Unix套接字的连接
 *      adb -p 5037 (adb devices)的设备名 shell cat /proc/net/unix
 * 查看webview所有的套接字
 *      adb -s 192.168.57.104:5555 shell cat /proc/net/unix |grep webview
 * 查看本地TCP端口与远程TCP端口的映射关系，把所有的有映射关系的端口全部列出来
 *      adb forward --list
 * 将本机PC端的TCP端口，映射到手机端
 *      adb forward LOCAL REMOTE
 * 将映射关系移出
 *      adb forward --remove
 * 总结：
 *      WebView可以通过ChromeInspect进行定位
 *      运行脚本的时候，通过日志查看执行过程，转发过程
 *      Appium通过底层完成工作引擎的切换，支持不同形态的自动化测试
 * native视角下的webview控件：
 *      uiautomator框架把webview组件"翻译"成了原生组件
 *          uiautormatorviewer、appium desktop、weditor 等都可以分析
 *          uiautormatorviewer对Java版本有要求，需要1.8.0_69一下版本
 *          uiautormatorviewer首次分析webview组件时需要多刷新一次
 *      控件转换：
 *          html控件尽量使用原生控件表达，比如文本转TextView,图片转image
 *          无适合原生控件表达的html控件用android.view.View表达
 *      属性转换：
 *          html控件中的属性用原生控件表达，根据不同的版本转换为resource-id content-desc text
 *          navtive无法表达的html属性会丢失，比如 class href src等属性
 * webView调试开关一定要打开, app的Chromedriver版本，优于系统的ChromeDriver的版本
 */
public class AndroidWebViewTest {
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
        // 允许显示指定版本对呀关系
//        desiredCapabilities.setCapability("chromedriverChromeMappingFile", "");
        // 让appium日志展示ChromeDriver的日志方便排查
        desiredCapabilities.setCapability("showChromedriverLog", true);
        // 在进行微信小程序测试时，需要将此设置为空
//        desiredCapabilities.setCapability("browserName", "");
        // 设置adb proxy
        // 通过自己的adb代理修复ChromeDriver的bug并解决@xweb_devtools_remote的问题
//        desiredCapabilities.setCapability("adbPort", "5037");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void sampleTest() {
        WebElement searchEle = driver.findElement(AppiumBy.id("com.xueqiu.android:id/home_search"));
        WebElement element = driver.findElement(AppiumBy.id("com.xueqiu.android:id/search_input_text"));
        driver.findElement(MobileBy.id(""));

        String attribute = element.getAttribute("resource-id");
        System.out.println("resource-id： "+ attribute);
        element.clear();
        element.sendKeys("alibaba");

        WebElement el = driver.findElement(AppiumBy.id("com.xueqiu.android:id/name"));
        String text = el.getText();
        // 进行上下文的切换
        Set<String> contextHandles = driver.getContextHandles();
        for (String context: contextHandles){
            System.out.println(context);
        }
        // 切换webView页面
        driver.context(contextHandles.toArray()[1].toString());
        // 或者切换方式：
        Stream<String> webview = contextHandles.stream().filter(s -> s.startsWith("WEBVIEW"));
        driver.context(webview.toArray()[0].toString());
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
