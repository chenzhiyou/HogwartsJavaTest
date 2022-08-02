package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * 选择添加方式界面
 */
public class AddContactMethodPage extends BasePage{
    public AddContactMethodPage(AndroidDriver driver) {
        super(driver);
    }

    // 切换到添加成员界面
    public EditContactPage goToEditContactPage(){
        // 选择手动输入添加
        driver.findElement(AppiumBy.id("com.tencent.wework:id/dvu")).click();
        return new EditContactPage(driver);
    }

    // 返回到通讯录界面
    public ContactPage backToContactPage(){
        // 点击添加成员界面左上角返回按钮
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(500));
        WebElement backElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.tencent.wework:id/kz6")));
        backElement.click();
        return new ContactPage(driver);
    }

}
