package com.hogwarts.appium.ch08_wework.page;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
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

    @Step("元素查找")
    public WebElement find(By by){
        WebElement element = driver.findElement(by);
        try {
            ElementScreenBase(element, by.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return element;
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
    public void ElementScreenBase(WebElement element, String messgae) throws IOException {
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
        Path pngPath = getPngPath();
        ImageIO.write(img, "png", pngPath.toFile());
        Allure.addAttachment(messgae,"image/png", new FileInputStream(pngPath.toFile()),".png");
    }

    public Path getPngPath() {
        long nowTime = System.currentTimeMillis();
        Path pngPath = Paths.get("png", nowTime + ".png");
        return pngPath;
    }
}
