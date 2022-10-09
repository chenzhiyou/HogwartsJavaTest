package com.javaIOStream;

import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;// 序列化的版本号，可以进行验证是否兼容
    private String name;
    private String address;

    public Employee() {
    }

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

/**
 * 一个对象要想序列化，必须满足两个条件：
 *      必须实现Serializable接口
 *      必须保证其所有属性均可序列化（transient修饰临时属性，不参与序列化）
 * 注意：
 *      对于JVM可以反序列化对象，它必须是能够找到class文件的类，如果找不到该类的class文件，则抛出一个ClassNotFoundException异常
 *      当JVM反序列化对象时，能找到class文件，但是class文件在序列化对象之后发生了修改，那么发序列化也会失败，抛出InvalidClassException异常，
 *          发生此异常原因：该类的序列版本号与从流中读取的类描述符的版本号不匹配，serialVersionUID该版本号的目的在于验证序列化的对象和对应类是否匹配
 */
public class SerialDemo {
    public static void main(String[] args) throws IOException {
        // 创建对象的输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Employee.txt"));
        Employee employee = new Employee("逍遥子", "杭州");
        // 序列化
        oos.writeObject(employee);
        // 关闭资源
        oos.close();
    }
}
