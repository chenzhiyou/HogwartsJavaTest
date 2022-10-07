package com.javaIOStream;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class FileDemo {
    // 递归遍历文件夹所有的内容;包括子层级的文件夹的内容
    public static void printDir(File dir){
        if (dir.isFile()&&dir.getName().endsWith(".java")){
            System.out.println("是文件" + dir);
        }else{
            File[] files = dir.listFiles();
            if (files !=null){
                for (File file: files){
                    if (file.isFile()&&file.getName().endsWith(".java")){
                        System.out.println(file);
                    }else {
                        printDir(file);
                    }
                }
            }

        }
    }

    // 使用文件过滤器进行过滤
    public static void useFileFilterPrintDir(File dir){
        if (dir.isFile()&&dir.getName().endsWith(".java")){
            System.out.println("是文件" + dir);
        }else{
            File[] files = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.isDirectory()||file.isFile()&&file.getName().endsWith(".java");
                }
            });
            if (files !=null){
                for (File file: files){
                    if (file.isDirectory()){
                        useFileFilterPrintDir(file);
                    }else {
                        System.out.println(file);
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        // 文件相关操作
        File file = new File("src/test/resources/demo.yaml");
        System.out.println("文件的绝对路径： "+ file.getAbsolutePath());
        System.out.println("文件名： "+ file.getName());
        System.out.println("文件的大小: "+ file.length());
        if (file.exists()){
            file.delete();// 删除文件
        }else{
            try {
                file.createNewFile();// 创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("是否是文件： " + file.isFile());
        System.out.println("是否是目录： " + file.isDirectory());
        // 文件夹相关操作
        File dir = new File("src/test/resources");
        System.out.println("文件夹的绝对路径： "+ dir.getAbsolutePath());
        System.out.println("文件夹名： "+ dir.getName());
        System.out.println("文件夹的大小: "+ dir.length());
        if (!dir.exists()){// 如果文件不存在
            dir.mkdir(); // 创建单级目录
            dir.mkdirs(); // 创建多级目录
        }
        System.out.println("是否是文件： " + dir.isFile());
        System.out.println("是否是目录： " + dir.isDirectory());

        // 获取目录下的所有的内容
        String[] list = dir.list();
        for (String str : list){
            // 打印的为文件的名称
            System.out.println("文件夹下的内容： " + str);
        }
        File[] files = dir.listFiles();
        for (File fileTmp : files){
            // 打印的为文件的路径
            System.out.println(fileTmp);
        }
        System.out.println("以下结果为递归调用===========================");
        printDir(dir);
        System.out.println("以下是使用文件过滤器的结果========================");
        useFileFilterPrintDir(dir);
    }
}
