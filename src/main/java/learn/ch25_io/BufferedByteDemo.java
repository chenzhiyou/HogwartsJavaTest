package learn.ch25_io;

import java.io.*;

public class BufferedByteDemo {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("/Users/lixiaochen/Downloads/javaCourse/text文本.txt"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/Users/lixiaochen/Downloads/javaCourse/test2.txt"));
            int res = 0;
            while (-1 != (res = bufferedInputStream.read())){
                bufferedOutputStream.write(res);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 后写的先关闭
            if (null != bufferedOutputStream){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bufferedInputStream){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }



    }
}
