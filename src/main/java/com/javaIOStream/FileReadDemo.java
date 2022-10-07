package com.javaIOStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadDemo {
    public static void main(String[] args) throws IOException {
        // 1、创建一个字符输入流
        FileReader fr = new FileReader("src/test/resources/data.yaml");
        // 2、读取数据
//        int ch;
//        while ((ch=fr.read())!=-1){
//            System.out.println("读取的一个字符： "+ (char)ch);
//        }
        // 使用字符数组的方式进行读取
        char[] chBuff = new char[3];
        int len;
        while ((len= fr.read(chBuff))!=-1){
            System.out.println("读取到的数据为： "+ new String(chBuff, 0, len));
        }

        fr.close();


    }
}
