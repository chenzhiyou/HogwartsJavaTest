package com.hogwarts.selenium.webAuto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class CookieBaseProTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ObjectMapper mapper;
    public static Faker faker;

    public void saveCookie() throws IOException {
        mapper = new ObjectMapper(new YAMLFactory());
        Set<Cookie> cookies = driver.manage().getCookies();
        mapper.writeValue(Paths.get("cookies.yaml").toFile(), cookies);
    }


    @Test
    public void cookieLogin() throws IOException {
        if (!Paths.get("cookie.yaml").toFile().exists()){
            saveCookie();
        }
        else{

        }
    }
}
