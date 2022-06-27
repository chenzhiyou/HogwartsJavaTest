package com.selenium.ch01_firstdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {
    public static void main(String[] args) {
        // 创建一个driver对象
        /**
         * 问题： 出现报错 The path to the driver executable
         * 原因：没有指定ChromeDriver的路径
         * 解决方法：指定ChromeDriver的路径或者配置环境变量
         * 指定ChromeDriver的路径：System.setProperty("webdriver.chrome.driver"，路径)
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://ceshiren.com/");
    }
}
