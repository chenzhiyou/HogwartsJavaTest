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
        driver.findElement(AppiumBy.xpath("//*[@text='添加成员']")).click();
        return new AddContactMethodPage(driver);
    }

    public SearchPage goToSearchPage(){
        driver.findElement(AppiumBy.id("com.tencent.wework:id/l00")).click();
        return new SearchPage(driver);
    }
}
