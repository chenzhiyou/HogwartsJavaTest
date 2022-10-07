package com.javaIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    public static void main(String[] args) throws IOException {
        // 1、创建输入输出流
        FileInputStream fis = new FileInputStream("src/test/resources/Redis图解.png");
        FileOutputStream fos = new FileOutputStream("src/test/resources/Redis.png");

        // 2、一边读取数据，一边写出数据
        byte[] buffer = new byte[1024];
        int len ; // 每次读取的有效的个数
        while ((len= fis.read(buffer))!=-1){
            fos.write(buffer, 0, len);
        }
        // 3、关闭输入输出流
        fos.close();
        fis.close();
    }
}
