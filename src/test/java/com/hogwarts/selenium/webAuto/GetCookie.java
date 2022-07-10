package com.hogwarts.selenium.webAuto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

/**
 * yaml文件读的封装
 */
public class GetCookie {

    public List<HashMap<String, Object>>  getCookieYaml(){
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return null;
    }

    public void saomaLogin(WebDriver driver, String preURL){

    }

    // 3、cook登录封装
    public void loginWithCookie(){
        List<HashMap<String, Object>> cookies = getCookieYaml();

    }
}
