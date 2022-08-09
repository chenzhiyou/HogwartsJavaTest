package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 搜索结果页
 */
public class SearchResultPage extends BasePage{
    public SearchResultPage(AndroidDriver driver) {
        super(driver);
    }

    public MemberInfoPage goToResult(){
        // 点击搜索结果
        driver.findElement(AppiumBy.id("com.tencent.wework:id/f2j")).click();
        return new MemberInfoPage(driver);
    }

    public List<String> noResult(){
        List<String> searchList = new ArrayList<>();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements(AppiumBy.className("android.widget.TextView"));
        elements.forEach(webElement -> searchList.add(webElement.getText()));
//        assertTrue(searchList.contains("无搜索结果"));
        return searchList;
    }
}
