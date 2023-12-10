package learn.ch25_io;

import java.io.*;

public class BufferedCharDemo {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/Users/lixiaochen/Downloads/javaCourse/test.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/lixiaochen/Downloads/javaCourse/test2.txt"));
            String str = null;
            while (null != (str = bufferedReader.readLine())) {
                bufferedWriter.write(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 后写的先关闭
            if (null != bufferedWriter) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
