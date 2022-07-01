package com.hogwarts.selenium.ch09_fileUploading;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUploadingTest {
    public  static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    @Test
    void fileUploadingTest() throws InterruptedException {
        driver.get("https:www.baidu.com");
        driver.findElement(By.xpath("//span[@class='soutu-btn']")).click();
        driver.findElement(By.xpath("//input[@class='upload-pic']")).sendKeys("/Users/lixiaochen/Desktop/Desktop/uploading.png");
        Thread.sleep(3000);
    }
}
