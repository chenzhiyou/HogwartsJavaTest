package com.hogwarts.ch12_interface;

public interface PriSchool {
    public default void study(){
        System.out.println("高薪就业");
    }
}
