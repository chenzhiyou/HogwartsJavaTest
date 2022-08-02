package com.util;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class FakerUtil {
    static Faker faker = new Faker(Locale.SIMPLIFIED_CHINESE);
    private static String[] telFirst = {"134", "135", "136", "137", "138", "139", "150", "151"};

    public static String get_name(){
        String name = faker.name().fullName();
        return name;
    }

    public static String get_zh_phone(){
        String s = faker.phoneNumber().subscriberNumber(8);
        int index = getNum(telFirst.length-1);
        String first = telFirst[index];
        return first+s;
    }

    private static int getNum(int num2) {
        Random ra = new Random();
        int number = ra.nextInt(num2);
        return number;
    }




}
