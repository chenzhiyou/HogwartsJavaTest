package com.hogwarts.selenium.ch13_cookies;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CookieTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    @BeforeAll
    public static void beforeAll(){
        driver = new ChromeDriver();
//        driver.get("https://work.weixin.qq.com/wework_admin/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterAll
    public static void afterAll(){
//        driver.quit();
    }

    /**
     * 将cookie信息存储下来
     * 1、访问登录页面
     * 2、扫描登录
     * 3、确认登录成功之后获取cookies
     * 4、将cookie写入文件中(yaml写入文件操作)
     */
    @Test
    public void saveCookies() throws IOException {
        driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx");
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        wait.until(ExpectedConditions.urlContains(url));
        Set<Cookie> cookies = driver.manage().getCookies();
        mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);

    }

    /**
     * 将cookie信息写入到浏览器中
     * 1、从yaml文件中读取信息
     * 2、将读取到的cookie信息，使用add方法，加载到浏览器中
     * 3、刷新页面
     */
    @Test
    public void loadCookies() throws IOException, InterruptedException {
        driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx");
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>(){};

        List<HashMap<String, Object>> cookies = mapper.readValue(new File("cookies.yaml"),typeReference);
        cookies.stream().forEach(
                cookie ->{
                    driver.manage().addCookie(
                            new Cookie(
                                    cookie.get("name").toString(),
                                    cookie.get("value").toString()));
                });
        driver.navigate().refresh();
        Thread.sleep(3000);
    }
}
