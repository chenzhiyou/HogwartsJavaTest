package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

public class WorkPage extends BasePage{
    public WorkPage(AndroidDriver driver) {
        super(driver);
    }

    public ClockInPage goToClockInPage() throws InterruptedException {
        // 进行滑动，展示出打卡按钮
        /**
         * 使用封装后的滑动代码
         */
        // 点击打卡按钮
        driver.findElement(AppiumBy.xpath("//*[@text='打卡']")).click();
        return new ClockInPage(driver);
    }
}
