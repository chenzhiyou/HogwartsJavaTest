package com.hogwarts.selenium.ch10_keyWord;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

/**
 * debug通常记录一些测试步骤信息
 * info 信息用来打印一些关键结果信息，比如断言
 */
public class SogouTest {
    public  static WebDriver driver;
    public static Logger logger;

    @BeforeAll
    static void setUp(){
        logger = LoggerFactory.getLogger(SogouTest.class);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    @Test
    void sogouTest(){
        logger.debug("搜狗搜索测试开始");
        driver.get("https://sogou.com");
        driver.findElement(By.id("query")).sendKeys("霍格沃兹测试学院");
        logger.debug("定位方式为：By.id,定位元素为query");
        driver.findElement(By.id("stb")).click();
        String res_text = driver.findElement(By.id("sogou_vr_30000000_0")).getText();
        logger.info("查找结果为"+ res_text);
    }

    /**
     *
     * getScreenshotAs(OutputType.FILE)
     * 关键页面
     *      断言页面
     *      重要的业务场景页面
     *      容易出错的页面
     */
    @Test
    void getScreenshotAsTest() throws IOException {
        logger.debug("搜狗截图测试开始");
        driver.get("https://sogou.com");
        logger.info("当前页面截图");
        File currentScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        logger.info("保存文件");
        FileUtils.copyFile(currentScreen, new File("./image.png"));
    }

    /**
     * 截图是当前定位元素的截图，截图更加精准，一般用于在做断言的时候
     * @throws IOException
     */
    @Test
    void sogouScreenSecondMethodTest() throws IOException {
        logger.debug("搜狗截图的第二种方式");
        driver.get("https://sogou.com");
        driver.findElement(By.id("query")).sendKeys("霍格沃兹测试学院");
        logger.debug("定位方式为：By.id,定位元素为query");
        driver.findElement(By.id("stb")).click();
        logger.info("在查找搜索结果的时候进行截图");
        WebElement res_ele = driver.findElement(By.id("sogou_vr_30000000_0"));
        File eleScreen = res_ele.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(eleScreen, new File("./image2.png"));
    }


    /**
     * 用于协助调试的过程中
     */
    @Test
    void getPageSourceTest() throws IOException, InterruptedException {
        driver.get("https://vip.ceshiren.com/#/layout/homeWork");
//        String pageSource = driver.getPageSource();
////        logger.debug(pageSource);
//        // 直接保存为文件格式
//        FileWriter pageSourceFile = new FileWriter("./pageSource.html");
//        pageSourceFile.write(pageSource);
        // 页面变化较多，页面元素可能一直在变化，解决方案：循环获取页面元素，对比变化
        int i = 0;
        while (i <= 3){
            // 循环，等待2秒获取pagesource页面数据
            Thread.sleep(500);
            String pageSource = driver.getPageSource();
//          logger.debug(pageSource);
            // 直接保存为文件格式
            FileWriter pageSourceFile = new FileWriter("./pageSource"+i+".html");
            pageSourceFile.write(pageSource);
            i++;
        }
    }
}
