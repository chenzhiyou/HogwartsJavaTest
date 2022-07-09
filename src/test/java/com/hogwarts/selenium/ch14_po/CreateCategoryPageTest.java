package com.hogwarts.selenium.ch14_po;

import com.selenium.ch14_po.CategoryPage;
import com.selenium.ch14_po.LoginPage;
import com.selenium.ch14_po.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;


import javax.swing.plaf.PanelUI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCategoryPageTest {
    public static LoginPage loginPage;
    public static MainPage mainPage;

    @BeforeAll
    static void setUp(){
        loginPage = new LoginPage("http://litemall.hogwarts.ceshiren.com/#/login");
        mainPage = loginPage.Login();
    }

    @AfterAll
    static void tearDown(){
//        loginPage.driver.quit();
        loginPage.quitDriver();

    }

    @AfterEach
    void afterEach() throws InterruptedException {
        mainPage.getURL("http://litemall.hogwarts.ceshiren.com/#/dashboard");
        Thread.sleep(2000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"小江山1", "小江山2"})
    void createCategory(String productName){
        CategoryPage category = mainPage
                .gotoCategoryPage()
                .gotoCreateCategoryPage()
                .createCategory(productName);

        List<WebElement> res = category.getResult(productName);
        System.out.println(res);
        assertEquals(1, res.size());
        category.deleteCategory(productName);

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        res = category.getResult(productName);
        assertEquals(0, res.size());

    }

    /**
     * 异常场景的测试 同样的行为不同的结果，需要有不同的方法
     * 问题：用例执行完成之后，如何回到初始状态
     * 解决方法：使用URL跳转的方式，回退到用例执行之前的初始状态，保证下个用例仍然能够正常执行
     * @throws InterruptedException
     */
    @Test
    void createCategoryFail() throws InterruptedException {
        String res = mainPage
                .gotoCategoryPage()
                .gotoCreateCategoryPage()
                .createCategoryFail();
        assertEquals("类目名不能为空", res);

    }
}
