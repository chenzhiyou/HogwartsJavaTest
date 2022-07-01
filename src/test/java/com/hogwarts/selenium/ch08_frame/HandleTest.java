package com.hogwarts.selenium.ch08_frame;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

/**
 * 多窗口处理流程：
 * 1、先获取到当前的窗口句柄(driver.getWindowHandle)
 * 2、再获取到所有的窗口句柄(driver.getWindowHandles)
 * 3、判断是否是想要操作的窗口，如果是，就可以对窗口进行操作，如果不是，需要跳转到另外一个窗口，对另一个窗口进行操作
 * (driver.switchTo().window(name))
 */
public class HandleTest {

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
    void switchHandlerTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("s-top-loginbtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("TANGRAM__PSP_11__regLink")).click();
        String handler1 = driver.getWindowHandle();
        Thread.sleep(2000);
        Set<String> handler_list = driver.getWindowHandles();
        System.out.println(handler1);
        System.out.println(handler_list);
        for (String handle: handler_list){
            if (handle.equalsIgnoreCase(handler1)){
                continue;
            }
            driver.switchTo().window(handle);
        }
        System.out.println(driver.getWindowHandle());

    }
}
