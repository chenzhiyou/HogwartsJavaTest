package com.datePackage;


import com.hogwarts.ceshiren.Calculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateDemo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        long time = date.getTime();
        System.out.println("当前时间的毫秒数：" + time);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));

        // string到date类型的转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "2022-10-06 00:00:00";
        Date parse = simpleDateFormat.parse(str);
        System.out.println("格式化后的日期："+ parse);
        String formatDate = simpleDateFormat.format(date);
        System.out.println("格式化后的日期： "+ formatDate);


    }
}
