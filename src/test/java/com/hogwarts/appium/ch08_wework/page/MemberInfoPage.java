package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

/**
 * 个人信息界面
 */
public class MemberInfoPage extends BasePage{
    public MemberInfoPage(AndroidDriver driver) {
        super(driver);
    }

    public String getMemberName(){
        // 获取联系人名称
        String name = driver.findElement(AppiumBy.xpath("//*[@text='小江山']")).getText();
        System.out.println(name);
        return name;
    }
}
