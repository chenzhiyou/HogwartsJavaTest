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
        String name = find(AppiumBy.xpath("//*[@text='小江山']")).getText();
        System.out.println(name);
        return name;
    }

    // 点击个人信息界面右上角的三个点按钮，进入到个人信息编辑界面
    public MemberInfoEditPage goToMemberInfoEditPage(){
        find(AppiumBy.id("com.tencent.wework:id/kzp")).click();
        return new MemberInfoEditPage(driver);
    }
}
