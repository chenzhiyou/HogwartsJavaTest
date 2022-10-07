package com.javaIOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class NormalDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/Redis图解.png");
        FileOutputStream fos = new FileOutputStream("src/test/resources/Redis1.png");

        // 读写数据
        int len;
        byte[] buff = new byte[1024];
        while ((len= fis.read(buff))!=-1){
            fos.write(buff, 0, len);
        }
        // 关闭资源
        fos.close();
        fis.close();
    }


}
