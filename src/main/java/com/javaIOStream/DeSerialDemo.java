package com.javaIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化
 */
public class DeSerialDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Employee.txt"));
        // 读取数据并恢复成对象
        Employee employee = (Employee) ois.readObject();
        System.out.println(employee);
        // 关闭资源
        ois.close();
    }
}
