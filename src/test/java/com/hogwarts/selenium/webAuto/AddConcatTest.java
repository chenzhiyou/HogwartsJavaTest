package com.hogwarts.selenium.webAuto;

import com.github.javafaker.Faker;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddConcatTest extends GetCookiesTest{
    /**
     * 1、cookie登录
     * 2、点击通讯录按钮，进入到通讯录界面
     * 3、添加对应的信息
     * 4、点击保存
     */

    @Test
    public void addMember() throws InterruptedException {
        GetCookiesTest login = new GetCookiesTest();
        login.loginByCookie();
        WebElement menu_contacts = driver.findElement(By.id("menu_contacts"));
        menu_contacts.click();

        By addMemberButton = By.xpath("//*[@class='ww_operationBar']/a[text()='添加成员']");
        wait.until(ExpectedConditions.elementToBeClickable(addMemberButton));
        WebElement addEle = driver.findElement(addMemberButton);
        addEle.click();


        String phoneNumber = "186"+ randomNum(8);
        String username = "小江山"+randomNum(4);
        String acctidStr = randomNum(14);
        System.out.println(phoneNumber);
        System.out.println(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        // 添加姓名
        WebElement addName = driver.findElement(By.name("username"));
        addName.clear();
        addName.sendKeys(username);

        WebElement acctid = driver.findElement(By.name("acctid"));
        acctid.clear();
        acctid.sendKeys(acctidStr);

        WebElement email = driver.findElement(By.xpath("//*[@name='biz_mail']"));
        email.clear();
        email.sendKeys(phoneNumber);

        WebElement phone = driver.findElement(By.id("memberAdd_phone"));
        phone.clear();
        phone.sendKeys(phoneNumber);

        Thread.sleep(5000);
        WebElement saveButton = driver.findElement(By.linkText("保存"));
        saveButton.click();

        Thread.sleep(5000);

        // 刷新页面
        driver.navigate().refresh();


        // 搜索添加的元素
        wait.until(ExpectedConditions.elementToBeClickable(By.id("memberSearchInput")));
        WebElement searchElement = driver.findElement(By.id("memberSearchInput"));
        searchElement.clear();
        searchElement.sendKeys(username);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".member_display_cover_detail_name")));
        String assertName = driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
        assertEquals(assertName, username);

        // 删除元素
        WebElement delElement = driver.findElement(By.cssSelector(".qui_btn ww_btn,  .js_del_member"));
        delElement.click();
        // 删除二次确认
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='qui_btn ww_btn ww_btn_Blue']")));
        WebElement delConfirmElement = driver.findElement(By.xpath("//*[@class='qui_btn ww_btn ww_btn_Blue']"));
        delConfirmElement.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ww_tip success']")));
//        String delSuccess = delElement.findElement(By.xpath("//*[@class='ww_tip success']")).getText();
//        System.out.println(delSuccess);
//        assertEquals("删除成功", delSuccess, "删除元素成功");
    }

}
