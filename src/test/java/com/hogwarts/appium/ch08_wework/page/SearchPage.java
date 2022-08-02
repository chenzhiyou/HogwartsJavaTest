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
    public SearchResultPage searchMember(){
        WebElement searchElement = driver.findElement(AppiumBy.xpath("//*[@text='搜索']"));
        searchElement.clear();
        searchElement.sendKeys("小江山");
        return new SearchResultPage(driver);
    }
}
