package com.hogwarts.webAuot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage(){
        if (driver ==null){
            driver = new ChromeDriver();
        }
    }
}
