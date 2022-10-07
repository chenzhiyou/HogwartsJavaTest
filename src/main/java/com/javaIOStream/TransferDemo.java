package com.javaIOStream;

import java.io.*;

public class TransferDemo {
    public static void main(String[] args) throws IOException {
        // 用默认的编码方式去读取
//        FileReader fr = new FileReader("src/main/java/com/javaIOStream/枭宠成瘾：病娇少帅的娇妻是大佬云乔席兰廷的副本.txt");
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src/main/java/com/javaIOStream/枭宠成瘾：病娇少帅的娇妻是大佬云乔席兰廷的副本.txt"), "GBK");



        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("病娇少帅的娇妻"));
        char[] charArr = new char[100];
        int len;
        while ((len=isr.read(charArr))!=-1){
            osw.write(charArr, 0, len);
            System.out.println(new String(charArr, 0, len));
        }
        isr.close();
        osw.close();
    }

}
