package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

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
    public SearchResultPage deleteMember(){
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
        String deleteString = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text('删除成功'))";
        driver.findElement(AppiumBy.androidUIAutomator(deleteString)).click();
        webDriverWait.until(webDriver-> webDriver.getPageSource().contains("邮件暂存30天"));
        driver.findElement(AppiumBy.xpath("//*[@text='确定']")).click();
        return new SearchResultPage(driver);
    }
}
