package com.hogwarts.selenium.ch15_advanced;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.fail;

public class ScreenTest {
    public static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    /**
     * 截图方法封装
     * @param 需要将driver传入
     * @throws IOException
     */
    void saveScreen(WebDriver driver) throws IOException {
        LocalDateTime nowTime = LocalDateTime.now();
        File currentScreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // 3、把截图保存成文件
        FileUtils.copyFile(currentScreen, new File("./files/"+ nowTime+".png"));
        Allure.addAttachment("add pic", "image/png", new FileInputStream("./files/"+ nowTime+".png"), "jpg");

    }
    @Test
    void ceshiren() throws IOException {
        driver.get("https://ceshiren.com");
        try {
            driver.findElement(By.name("adv"));
        }catch (Exception e){
            saveScreen(driver);
            System.out.println("执行case失败");
            fail("Exception"+ e);
        }
    }
}
