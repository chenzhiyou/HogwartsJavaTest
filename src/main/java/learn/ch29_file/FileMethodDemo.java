package learn.ch29_file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileMethodDemo {
    public static void main(String[] args) throws IOException {
        // 绝对路径实例化
        File file = new File("/Users/lixiaochen/Downloads/javaCourse/test.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println("文件的绝对路径为： "+ absolutePath);
        String path = file.getPath();
        System.out.println("文件的路径为： "+ path);
        String name = file.getName();
        System.out.println("文件的名称为： "+ name);
        long length = file.length();
        System.out.println("文件的长度为： "+ length);

        // 相对路径实例化：
        File relfile = new File("test.txt");
        String relfileAbsolutePath = relfile.getAbsolutePath();
        System.out.println("文件的绝对路径为： "+ relfileAbsolutePath);
        String relfilePath = relfile.getPath();
        System.out.println("文件的路径为： "+ relfilePath);
        String relfileName = relfile.getName();
        System.out.println("文件的名称为： "+ relfileName);
        long rel = relfile.length();
        System.out.println("文件的长度为： "+ rel);

        System.out.println("是否为文件： "+ file.isFile());
        System.out.println("是否存在： "+ file.exists());
        System.out.println("是否是文件夹： "+ file.isDirectory());

        // 实例化File文件对象
        File newFile = new File("./newFile.txt");
        // 创建文件
        System.out.println("创建文件： "+ newFile.createNewFile());
        System.out.println("删除文件： "+ newFile.delete());

        //创建目录
//        File hogwarts = new File("./hogwarts");
//        System.out.println("创建文件夹： "+ hogwarts.mkdir());

        // 获取文件名称数组
        File filePath = new File("/Users/lixiaochen/Downloads/javaCourse");
        String[] names = filePath.list();
        System.out.println(Arrays.toString(names));

        File[] files = filePath.listFiles();
        for (File file1: files){
            System.out.println(file1.length());
        }
    }
}
