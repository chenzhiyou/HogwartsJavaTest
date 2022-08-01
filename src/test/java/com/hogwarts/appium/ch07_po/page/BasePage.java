package com.hogwarts.appium.ch07_po.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    public AndroidDriver driver;

    public BasePage(){

    }

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By by){
        return driver.findElement(by);
    }
}
