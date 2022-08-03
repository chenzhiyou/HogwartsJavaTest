package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ClockInPage extends BasePage{
    public ClockInPage(AndroidDriver driver) {
        super(driver);
    }

    //进行打卡
    public void Clock(){
        // 判断是否已经在打卡范围内

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(2));
        wait.until(
                driver -> {
                    List<WebElement> elements = driver.findElements(AppiumBy.className("android.widget.TextView"));
                    List<String> textList = new ArrayList<>();
                    elements.forEach(
                            webElement -> textList.add(webElement.getText())
                    );
                    System.out.println(textList);
                    return textList.contains("你已在打卡范围内");
                }
        );
        // 点击打卡
        driver.findElement(AppiumBy.id("com.tencent.wework:id/bh6")).click();
    }
}
