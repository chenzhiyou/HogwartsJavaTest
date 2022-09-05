package com.hogwarts.interfaceTest.ch10_wework_interface;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    Properties properties = new Properties();

    public Object getProperties(String key){
        try {
            properties.load(getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.get(key);

    }
}
