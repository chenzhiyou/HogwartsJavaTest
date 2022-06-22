package com.hogwarts.junit5Basics.ch16_allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AllureAttachmentTest {

    @Test
    public void addAttachPictureTest() throws FileNotFoundException {
        Allure.addAttachment("文本信息", "My attachment content");
        Allure.addAttachment("图片", "image/jpg", new FileInputStream(""),"jpg");

    }
}
