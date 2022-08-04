package com.hogwarts.appium.ch07_po.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
}
