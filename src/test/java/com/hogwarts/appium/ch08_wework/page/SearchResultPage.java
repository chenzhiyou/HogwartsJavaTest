package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * 搜索结果页
 */
public class SearchResultPage extends BasePage{
    public SearchResultPage(AndroidDriver driver) {
        super(driver);
    }

    public MemberInfoPage goToResult(){
        driver.findElement(AppiumBy.id("com.tencent.wework:id/f2j")).click();
        return new MemberInfoPage(driver);
    }
}
