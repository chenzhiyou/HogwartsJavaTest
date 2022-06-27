package com.hogwarts.selenium.ch02_Button;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorTest {
    public static WebDriver driver;

    @BeforeAll
    static void setUpClass(){
        driver = new ChromeDriver();
    }

    @AfterAll
    static void teardownClass(){
        driver.quit();
    }

    // 通过ID进行定位
    @Test
    void locatorByID(){
        driver.get("https://ceshiren.com");
        WebElement logo = driver.findElement(By.id("site-logo"));
        System.out.println(logo);
    }

    // 通过name进行定位
    @Test
    void locatorByName(){
        driver.get("https://baidu.com");
        WebElement more = driver.findElement(By.name("tj_briicon"));
        System.out.println(more);
    }

    // 通过cssSelector定位方式
    @Test
    void locatorByCssSelector(){
        driver.get("https://ceshiren.com");
        WebElement cssElement = driver.findElement(By.cssSelector("#site-logo"));
        System.out.println(cssElement);
    }

    @Test
    void locatorByXpath(){
        driver.get("https://ceshiren.com");
        WebElement xpathElement = driver.findElement(By.xpath("//*[@id='site-logo']"));
        System.out.println(xpathElement);
    }

    @Test
    void locatorByLinkTest(){
        driver.get("https://ceshiren.com");
        WebElement linkElement = driver.findElement(By.linkText("Idea中Java的UI自动化环境部署"));
        System.out.println(linkElement);
    }

}
