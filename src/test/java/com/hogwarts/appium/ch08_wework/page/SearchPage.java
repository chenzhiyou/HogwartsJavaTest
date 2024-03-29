package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * 搜索界面
 */
public class SearchPage extends BasePage {
    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    // 搜索
    public SearchResultPage searchMember(String searchName){
        // 点击搜索框清空内容后输入要搜索内容
        WebElement searchElement = find(AppiumBy.xpath("//*[@text='搜索']"));
        searchElement.clear();
        searchElement.sendKeys(searchName);
        return new SearchResultPage(driver);
    }
}
