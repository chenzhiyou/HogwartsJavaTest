package com.hogwarts.learn.ch26_allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PngTest {

    @Test
    @DisplayName("allure图片注解的添加")
    public void andPngWithAttachmentAnTest() throws IOException {
        int contents = Files.newInputStream(Paths.get("alogo.png")).read();
//        attachPngFile(contents, "alogo.png)");
    }

    @Attachment(value = "{pngName}", type = "image/png", fileExtension = "png")
    public byte[] attachPngFile(byte[] contents, String pngName){
        return contents;
    }

    @Test
    @DisplayName("allure图片方法的添加")
    public void andPngWithMethodAnTest() throws IOException {
        Allure.addAttachment("alogo.png", "image/png", Files.newInputStream(Paths.get("alogo.png")),"png");
    }
}
