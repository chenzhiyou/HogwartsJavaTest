package com.ajaxPro;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;
    private String sex;
    private boolean status;
    private Score score;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", status=" + status +
                '}';
    }
}
