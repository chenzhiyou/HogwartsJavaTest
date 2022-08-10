package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 编辑成员界面
 */
public class EditMemberInfoPage extends BasePage{
    public EditMemberInfoPage(AndroidDriver driver) {
        super(driver);
    }

    // 删除成员，删除成功户返回到搜索结果界面
    public SearchResultPage deleteMember() throws IOException {
        // 滑动到底查找删除成员
        List<String> textList = new ArrayList<>();
//        do {
//            swipeUp();
//            List<WebElement> elements = driver.findElements(AppiumBy.className("android.widget.TextView"));
//            elements.forEach(webElement -> textList.add(webElement.getText()));
//        }while (
//                textList.contains("删除成员")
//        );
        // 使用Android原生定位
//        String deleteString = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text('删除成员'))";
        find(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"删除成员\"))")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofSeconds(2));

        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.tencent.wework:id/cjg")));
//        ElementScreenBase(webElement);
        webElement.click();
        return new SearchResultPage(driver);
    }
}
