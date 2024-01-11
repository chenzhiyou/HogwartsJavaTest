package learn.ch25_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDemo {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("/Users/lixiaochen/Downloads/javaCourse/text文本.txt");
            fileWriter = new FileWriter("/Users/lixiaochen/Downloads/javaCourse/test2.txt");
            int res = 0;
            while (-1 != (res = fileReader.read())){
                fileWriter.write(res);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 后写的先关闭
            if (null != fileWriter){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fileReader){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }



    }
}
