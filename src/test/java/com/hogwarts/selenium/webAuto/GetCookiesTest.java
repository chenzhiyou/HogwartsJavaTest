package com.hogwarts.selenium.webAuto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.javafaker.Faker;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;



/**
 * 1、设置全局变量，ChromeDriver如果没有配置全局变量则会报错
 * 2、打开Chrome浏览器
 * 3、访问企业微信登录页面
 * 4、扫码过程
 *      方式一：强制等待扫码
 *      方式二：显示等待扫码
 * 5、扫码后cookie保存到本地yaml文件 fasterjson writerVslue, readValue
 */
public class GetCookiesTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ObjectMapper mapper;
    public static Faker faker;


    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    public String randomNum(int n){
        String str = "";
        faker = new Faker();
        RandomService randomService = faker.random();
        for(int i =0; i<n;i++){
            str = str + randomService.nextLong(8);
        }
        return str;

    }
    @Test
    public void cookieTime() throws IOException {
        mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {};

        List<HashMap<String,Object>> cookies = mapper.readValue(Paths.get("cookies.yaml").toFile(), typeReference);

        List<Long> expiryList = new ArrayList<>();
        cookies.forEach(
                cookie ->{
                    if (cookie.get("expiry") != null){
                        String expiryStr = cookie.get("expiry").toString();
                        Long expireL = Long.valueOf(expiryStr);
                        expiryList.add(expireL);
                    }
                }
        );
        // 获取到了所有的截止时间戳
        System.out.println(expiryList);
        // 第一个截止时间戳是cookie文件的365天以后
        // cookie 文件的获取时间的时间戳
        Long nowCookieTime = expiryList.get(0) - 31536000000L;
        Long nowTime = System.currentTimeMillis();
        if (nowTime -nowCookieTime < 7200){
            System.out.println("使用cookie文件");
        }else {
            System.out.println("扫码登录。cookie失效");
        }
    }

    @Test
    public void getCookieTest() throws IOException, InterruptedException {
        driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx");
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        String preURL = driver.getCurrentUrl();
        wait.until(driver1 -> !driver1.getCurrentUrl().equals(preURL));
        mapper = new ObjectMapper(new YAMLFactory());
        Set<Cookie> cookies = driver.manage().getCookies();
        mapper.writeValue(Paths.get("cookies.yaml").toFile(), cookies);
    }

    @Test
    public void readCookieTest(){
        driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx");
        mapper = new ObjectMapper(new YAMLFactory());
        String preURL = driver.getCurrentUrl();
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {};
        try {
            List<HashMap<String,Object>> cookies = mapper.readValue(Paths.get("cookies.yaml").toFile(), typeReference);
            cookies.stream()
                    .filter(cookie -> cookie.get("domain").toString().contains(".work.weixin.qq.com"))
                    .forEach(
                            cookie ->{
                                driver.manage().addCookie(
                                        new Cookie(cookie.get("name").toString(),
                                                cookie.get("value").toString())
                                );
                            });
            driver.navigate().refresh();
            String afterURL = driver.getCurrentUrl();
            System.out.println(!afterURL.equals(preURL)? "登录成功":"登录失败");
            Thread.sleep(3000);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void loginByCookie(){
        driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx");
        mapper = new ObjectMapper(new YAMLFactory());
        String preURL = driver.getCurrentUrl();
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {};
        try {
            List<HashMap<String,Object>> cookies = mapper.readValue(Paths.get("cookies.yaml").toFile(), typeReference);
            cookies.stream()
                    .filter(cookie -> cookie.get("domain").toString().contains(".work.weixin.qq.com"))
                    .forEach(
                            cookie ->{
                                driver.manage().addCookie(
                                        new Cookie(cookie.get("name").toString(),
                                                cookie.get("value").toString())
                                );
                            });
            driver.navigate().refresh();
            String afterURL = driver.getCurrentUrl();
            System.out.println(!afterURL.equals(preURL)? "登录成功":"登录失败");
            Thread.sleep(3000);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }



}

