package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * 通讯录界面
 */
public class ContactPage extends BasePage{
    public ContactPage(AndroidDriver driver) {
        super(driver);
    }

    // 切换到选择添加方式界面
    public AddContactMethodPage goToChooseContactMethodPage(){
        // 点击添加成员
        find(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"添加成员\"))")).click();
//        driver.findElement(AppiumBy.xpath("//*[@text='添加成员']")).click();
//        driver.findElement(AppiumBy.cssSelector("[text='添加成员']")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text('通讯录')")).click();
        return new AddContactMethodPage(driver);
    }

    public SearchPage goToSearchPage(){
        // 点击搜索按钮
        find(AppiumBy.id("com.tencent.wework:id/l00")).click();
//        driver.findElement(AppiumBy.cssSelector("#com\\.tencent\\.wework\\:id\\/l00")).click();
        return new SearchPage(driver);
    }
}
