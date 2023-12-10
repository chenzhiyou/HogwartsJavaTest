package learn.ch25_io;

import java.io.*;

public class FileByteDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("/Users/lixiaochen/Downloads/javaCourse/test.txt");
            fileOutputStream = new FileOutputStream("/Users/lixiaochen/Downloads/javaCourse/test2.txt");
            int res = 0;
            // 字节为单位的文件读取
            while (-1 != (res = fileInputStream.read())) {
                fileOutputStream.write(res);
            }

            int size = fileInputStream.available();
            System.out.println("读到的文件的大小为： "+ size);
            byte[] bytes = new byte[size];
            int read = fileInputStream.read(bytes);
            System.out.println("读取到的文件的大小："+ read);
            fileOutputStream.write(bytes);

            //分批次的读取
            byte[] byteArray = new byte[1024];
            res = 0;
            while (-1 != (res = fileInputStream.read(byteArray))) {
                fileOutputStream.write(byteArray, 0, res);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 后写的先关闭
            if (null != fileOutputStream) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fileInputStream) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}