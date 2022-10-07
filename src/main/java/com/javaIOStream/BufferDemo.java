package com.javaIOStream;

import java.io.*;

public class BufferDemo {
    public static void main(String[] args) throws IOException {
        // 创建缓冲流的输入输出对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/test/resources/Redis图解.png"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/test/resources/Redis.png"));

        // 读写数据
        int len;
        byte[] buff = new byte[1024];
        while ((len= bis.read(buff))!=-1){
            bos.write(buff, 0, len);
        }
        bos.close();
        bis.close();
    }
}
