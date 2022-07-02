package com.hogwarts.selenium.ch12_remoteTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 * 设置chromeOptions的实例对象
 * 配置debug地址
 * 初始化浏览器并添加配置信息
 * 好处：解决比如企业微信只能扫码进行登录，需要人工介入的场景
 *      解决单独需要调试某些功能的场景
 */
public class RemoteTest {

    @Test
    void remoteLogin(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("debuggerAddress", "localhost:9222");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://baidu.com");
    }
}
