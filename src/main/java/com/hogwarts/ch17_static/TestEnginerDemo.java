package com.hogwarts.ch17_static;

public class TestEnginerDemo {
    public static void main(String[] args) {
        TestEnginer testEnginer1 = new TestEnginer();
        testEnginer1.setName("盖盖");
        testEnginer1.setWork("Java测试工程师");
//        testEnginer1.setDepartment("质量控制部");
        // 静态变量 变量存在一个公共地址--方法区内，同一个类的所有的实例都可以去访问
//        TestEnginer.department="质量";
        TestEnginer testEnginer2 = new TestEnginer();
        testEnginer2.setName("小七");
        testEnginer2.setWork("Pyth测试工程师");
//        testEnginer2.setDepartment("质量控制部");

        testEnginer1.selfIntroduction();
        testEnginer2.selfIntroduction();
    }
}
