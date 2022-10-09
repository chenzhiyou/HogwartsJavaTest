package com.javaIOStream;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("北京", "首都");
        properties.setProperty("长沙", "湖南省会");
        properties.setProperty("深圳", "直辖市");

        System.out.println(""+ properties.getProperty("长沙"));
        // 遍历
        Set<String> strings = properties.stringPropertyNames();
        for (String key : strings){
            System.out.println(""+ properties.getProperty(key));
        }
    }
}
