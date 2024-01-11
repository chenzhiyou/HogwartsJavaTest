package com.hogwarts.learn.ch26_allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

public class TextTest {

    @Test
    @DisplayName("注解，String类型")
    public void addTextForStringWithAnTest() throws IOException {
        File file = new File("text文本.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null ){
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
        }
        attachTextFile(stringBuilder.toString(), "text文本");
    }

    @Attachment(value = "text文本", type = "text/plain")
    String attachTextFile(String contents, String FileName){
        return contents;
    }


    @Test
    @DisplayName("方法，String类型")
    public void addTextForStringWithMethodTest() throws IOException {
        File file = new File("text文本.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null ){
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
        }
        Allure.addAttachment("方法添加文本", "text/plain", stringBuilder.toString(),"txt" );
    }
}
