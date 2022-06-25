package com.hogwarts.ch17_static;

public class TestEnginer {
    private String name;
    private String work;
    // static修饰的静态变量，被所有的实例共享，
    // 访问修饰符，如果没有，默认就是同包名下
    // final+static 常量
    public final static String DEPARTMENT="质量控制";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

//    public static String getDepartment() {
//        return department;
//    }
//
//    public static void setDepartment(String department) {
//        TestEnginer.department = department;
//    }

    public void selfIntroduction(){
        System.out.println("我是"+ DEPARTMENT+"部门的"+ getName()+",我的工作是"+ getWork());
    }


}
