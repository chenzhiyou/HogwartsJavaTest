package com.hogwarts.appium.ch03_wait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 显示等待：
 *      必须：每个需要等到的元素前面进行声明
 *      针对的是某个条件的等待时间，在设置的时间内，可以默认每隔段时间也可以指定每隔段多久去检查一次条件是否满足
 *      默认的检测频率是0.5
 * 显示等待声明：
 *      WebDriver:
 *          当前的driver驱动AndroidDriver、ChromeDriver
 *      timeout：
 *          显示等待的总时间，最长超时时间
 *      sleeper：
 *          每隔多久就去找一下对应的显示等待的条件
 *          检查显示等待条件的间隔步长
 *          默认500ms
 *      TimeoutException:
 *          默认抛出的异常
 *      显示等待传入报错Message：
 *          withMessage("报错Message")
 *              返回值false对应的报错信息
 *      ExpectedConditions：
 *          元素是否存在：
 *              presenceOfElementLocated
 *              元素在页面是否存在，不一定显示可见，只要在DOM树存在即可
 *              ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(""));
 *              如果元素存在，则返回true
 *          元素是否可见：
 *              visibilityOfElementLocated
 *              元素在页面是否可以肉眼可见
 *          元素是否不可见：
 *              invisibilityOfElementLocated
 *              与visibilityOfElementLocated相反
 *          元素是否可点击：
 *              elementToBeClickable
 *              如果元素可以点击，则返回true
 * Lambda表达式：
 *
 */
public class WebDriverWaitTest {
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

        WebElement el = driver.findElement(AppiumBy.id("com.xueqiu.android:id/name"));
        String text = el.getText();
        if (text.equals("阿里巴巴")){
            System.out.println("搜索成功");
        }else{
            System.out.println("搜索失败");
        }
        assertTrue(el.isDisplayed());
    }

    /**
     * 热榜-非肉眼可见的时候的点击
     */
    @Test
    public void waitTest(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(500));
        FluentWait<WebDriver> webDriverFluentWait = webDriverWait.withMessage("显示等待定位失败");
        webDriverFluentWait
                .until(
                        // 判断元素是否存在
                        // ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(""));
                // 等待条件
                ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//*[@text='热榜']")));
        driver.findElement(AppiumBy.xpath("//*[@text='热榜']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 热榜肉眼可见时的点击
     */
    @Test
    public void waitHotTest(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(500));
        FluentWait<WebDriver> webDriverFluentWait = webDriverWait.withMessage("显示等待定位失败");
        webDriverFluentWait
                .until(
                        // 判断元素是否存在
                        // ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(""));
                        // 等待条件
                        ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//*[@text='热榜']")));
        driver.findElement(AppiumBy.xpath("//*[@text='热榜']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // com.xueqiu.android:id/iv_fund_recommend2
    @Test
    public void hotFundRecommendTest(){
        // 1、热榜点击
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(500));
        FluentWait<WebDriver> webDriverFluentWait = webDriverWait.withMessage("显示等待定位失败");
        webDriverFluentWait
                .until(
                        // 判断元素是否存在
                        // ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(""));
                        // 等待条件
                        ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//*[@text='热榜']")));
        // 1、热榜点击
        driver.findElement(AppiumBy.xpath("//*[@text='热榜']")).click();
//        List<WebElement> elements = driver.findElements(AppiumBy.id("com.xueqiu.android:id/ll_first_row_content"));
        // 直到大盘行情不可见后，点击私募头条
        webDriverFluentWait.until(
                ExpectedConditions.invisibilityOfElementLocated(AppiumBy.id("com.xueqiu.android:id/ll_first_row_content"))
        );
        // 点击私募头条
        driver.findElement(AppiumBy.id("com.xueqiu.android:id/iv_fund_recommend2")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 元素可以被点击
    @Test
    public void elementToBeClickableTest(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(500));
        FluentWait<WebDriver> webDriverFluentWait = webDriverWait.withMessage("显示等待定位失败");
        webDriverFluentWait
                .until(
                        // 判断元素是否存在
                        // ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(""));
                        // 等待条件
                        ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//*[@text='热榜']")));
        driver.findElement(AppiumBy.xpath("//*[@text='热榜']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lambdaTest(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(500));
//        Function<WebDriver, Object> function = new Function<WebDriver, Object>() {
//            @Override
//            public Object apply(WebDriver driver) {
//                return driver.findElement(AppiumBy.xpath("//*[@text='热榜']"));
//            }
//        };

        FluentWait<WebDriver> withMessage = webDriverWait.withMessage("查找失败");
        // 使用lambda表达式
        withMessage.until(webDriver->webDriver.findElement(AppiumBy.xpath("//*[@text='热榜']")));
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

}
