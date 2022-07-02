package com.hogwarts.selenium.ch11_litemall;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LiteMallTest {
    public  static WebDriver driver;
    public static Logger logger;
    public static WebDriverWait wait;
    public static FluentWait<WebDriver> fluentWait;

    @BeforeAll
    static void setUp(){
        logger = LoggerFactory.getLogger(LiteMallTest.class);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 使用流等待
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(ElementClickInterceptedException.class);
        login();
    }

    void saveScreen() {
        /**
         * 1、生成时间戳
         * 2、生成截图文件
         * 3、保存到报告中
         */
        try{
            Long nowTime = System.currentTimeMillis();
            String fileName = "./files/"+nowTime+".png";
            File currentScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(currentScreen, new File(fileName));
            Allure.addAttachment("picture", "image/png", new FileInputStream(fileName),".png");
        }catch (Exception e){
            logger.warn("截图失败");
        }

    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }


    public static void login(){
        driver.get("http://litemall.hogwarts.ceshiren.com/#/login");
        driver.findElement(By.xpath("//button")).click();
        logger.info("点击商品管理");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='商场管理']")));
        element.click();
        driver.findElement(By.xpath("//span[text()='商品类目']")).click();
    }

    @Test
    void addProductTest(){
        logger.info("点击添加按钮");
        driver.findElement(By.xpath("//*[@class='el-icon-edit']")).click();
        String productName = "小江山";
        driver.findElements(By.xpath("//*[@class='el-input__inner']")).get(0).sendKeys(productName);
        /**
         * 使用流等待
         * 显示等待自带的条件无法解决报错问题，
         * 解决方案：使用流等待，忽略对应的异常信息
         * 使用 utils 的机制，重复点击按钮，直到消息提示框出现为止
         */
//        WebElement confirmButton =wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.xpath("//*[@class='dialog-footer']//button")).get(1)));
        fluentWait.until(driver1 -> {
            driver1.findElement(By.xpath("//*[@class='dialog-footer']//*[text()='确定']")).click();
            return driver.findElement(By.cssSelector(".el-notification__title"));
        });
        logger.info("进行断言，判断是否真的添加成功");
        List<WebElement> elementList = driver.findElements(By.xpath("//*[text()='小江山']"));
        saveScreen();
        assertEquals(1, elementList.size());
        driver.findElement(By.xpath("//*[text()='小江山']/../..//*[text()='删除']")).click();

    }

    @Test
    void deleteProductTest(){
        logger.info("点击添加按钮");
        driver.findElement(By.xpath("//*[@class='el-icon-edit']")).click();
        String productName = "小江山-删除测试";
        driver.findElements(By.xpath("//*[@class='el-input__inner']")).get(0).sendKeys(productName);
        fluentWait.until(driver1 -> {
            driver1.findElement(By.xpath("//*[@class='dialog-footer']//*[text()='确定']")).click();
            return driver.findElement(By.cssSelector(".el-notification__title"));
        });
        driver.findElement(By.xpath("//*[text()='小江山-删除测试']/../..//*[text()='删除']")).click();
        logger.info("进行断言，判断是否真的删除成功");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='小江山-测试删除']")));
        List<WebElement> elementList = driver.findElements(By.xpath("//*[text()='小江山-测试删除']"));
        saveScreen();
        assertEquals(0, elementList.size());
    }

}
