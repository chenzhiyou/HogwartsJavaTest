package com.javaIOStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        // 1、创建字节输出流
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("src/test/resources/allureStudy1.txt",true);
            // 默认是覆盖原有的内容,如果是追加，需要增加append属性为true
            //FileOutputStream fileOutputStream = new FileOutputStream(new File("src/test/resources/allureStudy.txt")); 不常用
            // 2、 写出数据到硬盘上
            fos.write(97);
            fos.write(98);
            fos.write(99);
            // 写一个字节数组
            byte[] bytes = "hello, world".getBytes(StandardCharsets.UTF_8);
            fos.write(bytes);
            // 写一个字节数组，指定区间
            byte[] bytes1 = "今天是一个好日子".getBytes(StandardCharsets.UTF_8);
            fos.write(bytes1, 4, 3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // 3、最后一定要关闭流

    }
}
