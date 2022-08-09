package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

public class BasePage {
    public AndroidDriver driver;
    public WebDriverWait webDriverWait;

    public BasePage(){

    }

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By by){
        return driver.findElement(by);
    }

    // 滑动方法封装
    public void swipeAction(Point startPoint, Point endPoint){
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
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向上滑动
     */
    public void swipeUp(){
        Dimension dimension = driver.manage().window().getSize();
        Point startPoint = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.9));
        Point endPoint = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.3));
        swipeAction(startPoint, endPoint);
    }
}
