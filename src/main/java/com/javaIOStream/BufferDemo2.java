package com.javaIOStream;

import java.io.*;

// 字符缓冲了
public class BufferDemo2 {
    public static void main(String[] args) throws IOException {
        // 创建字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/allureStudy.txt"));
        String line;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("src/test/resources/allureStudy2.txt"));
        bw.write("hello");
        bw.newLine();// 换行
        bw.close();
    }
}
