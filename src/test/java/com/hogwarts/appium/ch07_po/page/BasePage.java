package com.hogwarts.appium.ch07_po.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BasePage {
    public AndroidDriver driver;
    List<By> blackList = Arrays.asList(AppiumBy.id(""),
            AppiumBy.id(""));

    public BasePage(){

    }

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // 添加黑名单的处理逻辑
    public WebElement find(By by){
        try{
            screen();
            return driver.findElement(by);
        }catch (Exception e){
            for (By by1 : blackList) {
                List<WebElement> elements =driver.findElements(by1);
               if (elements.size()>0){
                    elements.get(0).click();
                    return find(by);
                }
            }
            throw e;
        }
    }

    // 显示等待封装
    public WebDriverWait waitWithUtil(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(1));
        return webDriverWait;
    }

    // 截图代码封装 appium  selenium使用的是同一个截图方法
    public void screen(){
        long l = System.currentTimeMillis();
        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File file = Paths.get("jpg",+l+".jpg").toFile();
        try {
            FileUtils.copyFile(screenshotAs, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
