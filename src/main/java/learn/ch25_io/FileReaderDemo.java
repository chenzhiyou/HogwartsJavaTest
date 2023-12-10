package learn.ch25_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("/Users/lixiaochen/Downloads/javaCourse/test.txt");
            int res = 0;
//            System.out.println("读出来的内容为： "+ (char)read);

            System.out.println("************while循环读取全部内容***************");
            while (-1 != (res = fileReader.read())){
                System.out.println("读出来的内容为： "+ (char)res);
            }
            // 读取部分内容
            System.out.println("************读取部分数据***************");
            char[] chars = new char[5];
            fileReader = new FileReader("/Users/lixiaochen/Downloads/javaCourse/test.txt");
            int read = fileReader.read(chars, 1, 2);
            System.out.println("读取到的个数为： "+ read);
            for (char c : chars){
                System.out.println("数组中读取到的内容为： "+ c);
            }
            read = fileReader.read(chars);
            for (char c : chars){
                System.out.println("数组中读取到的内容为： "+ c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
