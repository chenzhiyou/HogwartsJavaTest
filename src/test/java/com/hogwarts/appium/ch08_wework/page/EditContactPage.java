package com.hogwarts.appium.ch08_wework.page;

import com.github.javafaker.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

// 添加联系人界面
public class EditContactPage extends BasePage{
    public EditContactPage(AndroidDriver driver) {
        super(driver);
    }

    public AddContactMethodPage addMember(String name, String phone){
        // 联系人名称
        WebElement nameElement = find(AppiumBy.id("com.tencent.wework:id/bwp"));
        nameElement.clear();
        nameElement.sendKeys(name);
        // 联系人手机号
        WebElement phoneElement = find(AppiumBy.id("com.tencent.wework:id/hyw"));
        phoneElement.clear();
        phoneElement.sendKeys(phone);
        WebElement saveElement = find(AppiumBy.xpath("//*[@text='保存']"));
        saveElement.click();
        return new AddContactMethodPage(driver);
    }
}
