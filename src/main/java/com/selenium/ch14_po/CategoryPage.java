package com.selenium.ch14_po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * 类名列表页面
 */
public class CategoryPage extends BasePage{
    private final By addButtonBy = By.xpath("//*[@class='el-icon-edit']");
    private final By deleteButtonBy = By.xpath("//*[text()='小江山-删除测试']/../..//*[text()='删除']");

    public CategoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

    public CreateCategoryPage gotoCreateCategoryPage(){
        find(addButtonBy).click();
        return new CreateCategoryPage(driver,wait);
    }

    public List<WebElement> getResult(String productName){
        List<WebElement> elementList = driver.findElements(By.xpath("//*[text()='"+productName+"']"));
        return elementList;
    }

    public void deleteCategory(String productName){
        find(By.xpath("//*[text()='"+productName+"']/../..//*[text()='删除']")).click();
    }
}
