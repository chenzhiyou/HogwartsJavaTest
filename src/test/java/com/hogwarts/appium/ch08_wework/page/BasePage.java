package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

public class BasePage {
    public AndroidDriver driver;


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

    /**
     * 截图
     * @param message
     */
    public void screen(String message){
        long nowTime = System.currentTimeMillis();
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path jpgPath = Paths.get("jpg", nowTime + ".jpg");
        File file = jpgPath.toFile();
        try {
            FileUtils.copyFile(screenShot, file);
            Allure.addAttachment(message, "image/jpg", new FileInputStream(jpgPath.toFile()), ".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 元素选中高亮
     * @param element
     * @return
     */
    public void ElementScreenBase(WebElement element) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        org.openqa.selenium.Point elementLocation = element.getLocation();
        org.openqa.selenium.Dimension elementSize = element.getSize();
        int eleX = elementLocation.x;
        int eleY = elementLocation.y;
        int eleH = elementSize.height;
        int eleW = elementSize.width;
//        logger.info("location=${} size=${} x=${} y=${} width=${} height=${}",
//                elementLocation,elementSize,eleX,eleY,eleW,
//                eleH);
        //读取截图文件
        BufferedImage img = ImageIO.read(screenshot);
        //创建一个 Graphics2D，可用于绘制到此 BufferedImage 中
        Graphics2D graph = img.createGraphics();
        //BasicStroke 指定线宽的实心  描边 Shape 的 Stroke 对象
        graph.setStroke(new BasicStroke(5));
        graph.setColor(Color.RED);//绘制形状的颜色
        graph.drawRect(eleX, eleY, eleW, eleH);//绘制指定矩形的轮廓
        graph.dispose();//处理此图形上下文并释放它正在使用的任何系统资源
        ImageIO.write(img, "png", getPngPath().toFile());
    }

    public Path getPngPath() {
        long nowTime = System.currentTimeMillis();
        Path pngPath = Paths.get("png", nowTime + ".png");
        return pngPath;
    }
}
