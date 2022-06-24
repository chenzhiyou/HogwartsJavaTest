package com.hogwarts.ch15_entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class User {
    private static Map<Integer, String> global_user = new HashMap<>();

    public static String get(int id){
        return global_user.get(id);
    }

    public static void add(int id, String name){
        global_user.put(id, name);
    }

    public static void update(int id, String name){
        global_user.put(id, name);
    }

    public static void remove(int id){
        global_user.remove(id);
    }

    public static void clear(){
        global_user.clear();
    }

    public static Collection<String> getUser(){
        return global_user.values();
    }


}
