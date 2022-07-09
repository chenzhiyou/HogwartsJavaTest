package com.selenium.ch14_po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 问题：虽然继承了，但是依然一直重复的打开浏览器，每次new一个新的page，只要继承了BasePage就会不停的重复打开浏览器
 * 解决：
 *      1、
 */
public class MainPage extends BasePage{
    private final By marketManageButton = By.xpath("//span[text()='商场管理']");
    private final By CategoryButton = By.xpath("//span[text()='商品类目']");

    // 构造函数
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

    public CategoryPage gotoCategoryPage(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(marketManageButton));
        element.click();
        find(CategoryButton).click();
        return new CategoryPage(driver, wait);
    }
}
