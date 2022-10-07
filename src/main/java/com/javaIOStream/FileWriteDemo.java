package com.javaIOStream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("writer.txt");
        // 写出一个字符
        fw.write(97);
        fw.write(98);
        fw.write(99);

        // 写出一个字符数组
        char[] chars = "abcdef".toCharArray();
        fw.write(chars);

        // 直接写出字符串
        fw.write("wwwwhelloworld");
        fw.close();

    }
}
