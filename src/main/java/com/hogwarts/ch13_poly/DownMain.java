package com.hogwarts.ch13_poly;

public class DownMain {
    public static void main(String[] args) {
        // 向上转型
        Person person = new DownWorker();
        person.run();

        // 向下转型
        DownWorker worker = (DownWorker) person;
        
    }
}
