package com.hogwarts.selenium.ch05_ceshiren;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class CeShiRenTest {
    public static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
    }


    @AfterAll
    static void tearDown(){
        driver.quit();
    }


    @Test
    void search() throws InterruptedException {
        driver.get("https://ceshiren.com");
        WebElement searchBtn = driver.findElement(By.id("search-button"));
        searchBtn.click();
        driver.findElement(By.id("search-term")).sendKeys("selenium");
        driver.findElement(By.cssSelector(".show-advanced-search")).click();
        Thread.sleep(3000);
        // 预期结果：搜索结果包含selenium
        WebElement title  = driver.findElement(By.cssSelector(".topic-title"));
        System.out.println(title.getText());
        List<WebElement> ele_titles = driver.findElements(By.cssSelector(".topic-title"));
        System.out.println(ele_titles.get(0).getText());
        // 进行断言
        assertThat(title.getText(), is(containsString("selenium")));

    }
}
