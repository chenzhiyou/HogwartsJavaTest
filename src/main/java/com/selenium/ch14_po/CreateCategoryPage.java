package com.selenium.ch14_po;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateCategoryPage extends BasePage{

    private final By addCategoryInput = By.xpath("//*[@class='el-input__inner']");
    private final By confirmCategoryButton = By.xpath("//*[@class='dialog-footer']//*[text()='确定']");
    private final By categoryMessage = By.cssSelector(".el-notification__title");
    // 获取错误信息的提示
    private final By errorMessage = By.cssSelector(".el-form-item__error");

    public CreateCategoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

    public CategoryPage createCategory(String productName){
        driver.findElements(addCategoryInput).get(0).sendKeys(productName);
        getFluentWait().until(driver1 -> {
            find(confirmCategoryButton).click();
            return driver.findElement(categoryMessage);
        });
        return new CategoryPage(driver,wait);
    }

    public String createCategoryFail() throws InterruptedException {
//        driver.findElements(addCategoryInput).get(0).sendKeys(" ");
        Thread.sleep(3000);
        find(confirmCategoryButton).click();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));

        String messageText = element.getText();
        return messageText;


    }
}
