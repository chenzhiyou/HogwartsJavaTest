package com.hogwarts.appium.ch07_po;

import com.hogwarts.appium.ch07_po.page.XueQiuAPP;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * PO模式六大原则
 *      分为三层：
 *          具体业务层
 *          公共业务层
 *          和业务无关的公共方法层
 */
public class POTest {
    public static XueQiuAPP xueQiuAPP;

    @BeforeAll
    public static void Before(){
        xueQiuAPP = new XueQiuAPP().startApp();
    }

    @Test
    public void search(){
        String price = xueQiuAPP // 启动雪球APP
                .toSearchPage() // 点击搜索跳转到搜索页面
                .toSearchResultPage()// 搜索页面输入内容，跳转到搜索结果页面
                .getPrice(); // 获取当前股票的金额
        Double priceDouble = Double.valueOf(price);
        assertThat(priceDouble,is(closeTo(110*(1-0.1), 110*(1+0.1))));
    }

    @AfterAll
    public static void after(){
        xueQiuAPP.quite();
    }
}
