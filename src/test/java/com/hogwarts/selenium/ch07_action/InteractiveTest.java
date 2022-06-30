package com.hogwarts.selenium.ch07_action;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * actions:执行PC端的鼠标点击，双击、右键、拖拽等事件
 * TouchActions：模拟PC和移动端的点击，滑动、拖拽、多点触控等多种手势操作
 */
public class InteractiveTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        actions = new Actions(driver);
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    @Test
    public void click(){
        driver.get("http://sahitest.com/demo/clicks.htm");
        WebElement clickEle = driver.findElement(By.xpath("//input[@value='click me']"));
        actions.click(clickEle);
        actions.perform();
        WebElement result = driver.findElement(By.name("t2"));
//        String text = result.getText();
//        assertThat(text, is(equalTo("[CLICK]")));
    }

    @Test
    public void moveTest(){
        driver.get("https://www.baidu.com");
        actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
        actions.perform();
    }

    @Test
    public void dragTest(){
        driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
        actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("")));
        actions.perform();
    }

    @Test
    public void actionTest(){
        driver.get("http://sahitest.com/demo/label.htm");
        driver.findElements(By.xpath("//input[@type='textbox']")).get(0).sendKeys("ashin");
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
        actions.keyDown(driver.findElements(By.xpath("//input[@type='textbox']")).get(1),Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
    }

    @Test
    public void scrollTest(){
        driver.get("https://baidu.com");
        driver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院");
        actions.click(driver.findElement(By.id("su"))).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("//a[@class='n']")).click();
    }

}
