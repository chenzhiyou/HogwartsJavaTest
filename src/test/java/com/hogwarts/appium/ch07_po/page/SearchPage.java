package com.hogwarts.appium.ch07_po.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * 搜索界面
 */
public class SearchPage extends XueQiuAPP{
    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    // 搜索结果操作到搜索结果界面
    public SearchResultPage toSearchResultPage(String text){
        // 1、输入alibaba
        WebElement searchElement = find(AppiumBy.id("com.xueqiu.android:id/search_input_text"));
        searchElement.clear();
        searchElement.sendKeys(text);
        searchElement.click();
        // 2、点击第一个搜索结果，跳转到搜索结果界面
        String elemeentText = "//*[@text='"+text+"']";
        driver.findElements(AppiumBy.xpath(elemeentText)).get(1).click();
//        find(AppiumBy.id("com.xueqiu.android:id/listview")).click();
        return new SearchResultPage(driver);
    }
}
