package com.javaIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {

        // 创建输入流的对象
        FileInputStream fis = new FileInputStream("src/test/resources/allureStudy1.txt");
        // 循环读取数据，一个字节一个字节的读取
//        int c;
//        while ((c= fis.read())!=-1){
//            char ch = (char) c;
//            System.out.println("字符为： "+ ch);
//        }
        System.out.println("====================================");
        // 读取一个字节数组
        byte[] bytes = new byte[6];
        int length;// 每次去取到的字节的个数 有效读取的个数
        while ((length=fis.read(bytes))!=-1){
            System.out.println("字符为： "+ new String(bytes, 0, length));
        }
        // 关闭流，避免资源的消耗
        fis.close();


    }
}
