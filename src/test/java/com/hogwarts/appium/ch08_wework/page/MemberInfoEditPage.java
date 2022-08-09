package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MemberInfoEditPage extends BasePage{
    public MemberInfoEditPage(AndroidDriver driver) {
        super(driver);
    }

    public EditMemberInfoPage editMember(){
        driver.findElement(AppiumBy.xpath("//*[@text='编辑成员']")).click();
        return new EditMemberInfoPage(driver);
    }
}
