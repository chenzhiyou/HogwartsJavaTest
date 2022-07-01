package com.hogwarts.selenium.ch08_frame;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * 在页面操作中有时会遇到JavaScript所生成的alert、confirm以及prompt弹窗，可以使用switch_to.alert()方法定位到
 * 常用的alert方法：
 *      driver.switchTo().alert():获取当前页面上的警告框
 *      text：返回alert/confim/prompt中的文字信息
 *      accept():接受现有警告框
 *      dismiss():解散现有警告框
 */
public class AlertTest {
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
    void alertTest(){
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
        driver.switchTo().frame("iframeResult");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).perform();
        driver.switchTo().alert().accept();
        driver.switchTo().parentFrame();

        System.out.println(driver.findElement(By.id("submitBTN")).getText());
    }
}
