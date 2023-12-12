package learn.ch29_file;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        // 1、通过文件路径名
        File macFile = new File("");
        // 2、通过父路径+子路径字符串
        File myFile = new File("" + "");

        // 通过父对象+子路径
        File parentFile = new File("");
        File childFile = new File(parentFile, "");
    }
}
