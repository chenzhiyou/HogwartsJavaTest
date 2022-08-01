package com.hogwarts.appium.ch07_po.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * 搜索结果界面
 */
public class SearchResultPage extends XueQiuAPP{
    public SearchResultPage(AndroidDriver driver) {
        super(driver);
    }

    // 点击股票的tab
    // 获取股票的金额，结果返回
    public String getPrice(){
        find(AppiumBy.xpath("//*[@text='股票']")).click();
        String priceText = find(AppiumBy.id("com.xueqiu.android:id/current_price")).getText();
        System.out.println(priceText);
        return priceText;
    }
}
