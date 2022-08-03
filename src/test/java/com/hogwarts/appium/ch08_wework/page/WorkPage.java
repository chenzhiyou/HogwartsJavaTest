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
         * 滑动的起始坐标
         */
        Dimension dimension = driver.manage().window().getSize();
        Point startPoint = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.9));
        Point endPoint = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.3));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence =new Sequence(finger, 1)
                .addAction(
                        finger.createPointerMove(
                                Duration.ofMillis(0),
                                PointerInput.Origin.viewport(),
                                startPoint.getX(), startPoint.getY()
                        )
                )
                .addAction(
                        finger.createPointerDown(
                                LEFT.asArg()
                        )
                )
                .addAction(
                        finger.createPointerMove(
                                Duration.ofMillis(1),
                                PointerInput.Origin.viewport(),
                                endPoint.getX(), endPoint.getY()
                        )
                )
                .addAction(finger.createPointerUp(
                        LEFT.asArg()
                ));
        driver.perform(Arrays.asList(sequence));
        sleep(500);
        // 点击打卡按钮
        driver.findElement(AppiumBy.xpath("//*[@text='打卡']")).click();
        return new ClockInPage(driver);
    }
}
