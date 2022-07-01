package com.hogwarts.selenium.ch08_frame;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * 多frame切换:一种嵌套的，一种是非嵌套的
 * driver.switch_to.frame() 根据元素ID或者index切换frame
 * driver.switch_to.default_content() 切换到默认的frame
 * driver.switch_to.parent_frame() 切换到父级frame
 */
public class FrameTest {
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
    void frameTest(){
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.id("draggable")).getText());
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.id("submitBTN")).getText());
    }
}
