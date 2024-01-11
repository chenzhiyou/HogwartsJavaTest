package learn.ch25_io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            // 如果文件不存在，自动创建
            // 若问津存在，清空原有内容
            fileWriter = new FileWriter("/Users/lixiaochen/Downloads/javaCourse/text文本.txt");
            fileWriter.write("a");
            char[] chars = new char[]{'h','e','l', 'l', 'o'};
            fileWriter.write(chars, 1, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != fileWriter){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
