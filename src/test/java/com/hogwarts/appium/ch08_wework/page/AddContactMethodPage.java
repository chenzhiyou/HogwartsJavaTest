package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

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

}
